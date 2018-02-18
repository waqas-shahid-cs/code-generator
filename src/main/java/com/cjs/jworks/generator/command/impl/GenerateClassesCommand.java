package com.cjs.jworks.generator.command.impl;

import com.cjs.jworks.generator.command.base.ContextCommand;
import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.*;
import com.cjs.jworks.generator.dto.impl.*;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.sql.SQLException;
import java.util.Scanner;

public class GenerateClassesCommand extends ContextCommand {
    private static final String PACKAGE_CONTROLLER = "package.controller";
    private static final String PACKAGE_ENTITY = "package.entity";
    private static final String PACKAGE_DOMAIN = "package.domain";
    private static final String PACKAGE_SERVICE = "package.service";
    private static final String PACKAGE_SERVICE_IMPL = "package.service.impl";
    private static final String PACKAGE_REPOSITORY = "package.repository";

    private static final String YES = "Y";

    private static final String PATH_SQL = "path.sql";
    private static final String PATH_JS = "path.js";

    public GenerateClassesCommand(final Context context) {
        super(context);
    }

    public void execute() throws Exception {
        try (final Scanner scanner = new Scanner(System.in)) {
            final EntityMeta entityMeta = readEntityMeta(scanner);
            final DomainMeta domainMeta = readDomainMeta(scanner, entityMeta);
            final CodeTableMeta codeTableMeta = readCodeTableMeta(scanner, entityMeta);
            File entityFile;
            if (codeTableMeta != null) {
                entityFile = getContext().getGeneratorFactory().getCodeTableFeatureGenerator().generate(codeTableMeta);
                System.out.println("Code Table files has been generated.");
            } else {
                entityFile = getContext().getGeneratorFactory().getEntityGenerator().generate(entityMeta);
                System.out.println("Entity has been generated.");
            }

            if (entityFile != null && entityFile.exists()) {
                getFactory().getDomainGenerator().generate(domainMeta);
                System.out.println("Domain has been generated.");

                final RepositoryMeta repositoryMeta = new RepositoryMetaImpl(entityMeta.getName() + "Repository", getPath(PACKAGE_REPOSITORY), entityMeta, getPackage(PACKAGE_REPOSITORY));
                getFactory().getRepositoryGenerator().generate(repositoryMeta);
                System.out.println("Repository has been generated.");

                final ClassMeta baseServiceMeta = new ClassMetaImpl(domainMeta.getName() + "Service", getPath(PACKAGE_SERVICE), getPackage(PACKAGE_SERVICE));
                final ClassMeta serviceImplMeta = new ClassMetaImpl(domainMeta.getName() + "ServiceImpl", getPath(PACKAGE_SERVICE_IMPL), getPackage(PACKAGE_SERVICE_IMPL));
                final ServiceMeta serviceMeta = new ServiceMetaImpl(baseServiceMeta, serviceImplMeta, domainMeta, repositoryMeta);
                getFactory().getServiceGenerator().generate(serviceMeta);
                System.out.println("Service has been generated.");

                final ControllerMeta controllerMeta = readControllerMeta(scanner, serviceMeta);
                getFactory().getControllerGenerator().generate(controllerMeta);
                System.out.println("Controller has been generated.");
            }
        }
    }

    protected EntityMeta readEntityMeta(final Scanner scanner) {
        System.out.print("Entity Name: ");
        final String name = scanner.nextLine();
        System.out.print("Table Name: ");
        final String table = scanner.nextLine();
        TableMeta tableMeta = null;
        try {
            tableMeta = getContext().getDbManager().getTableMeta(table);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            tableMeta = new TableMetaImpl(table, getFieldsMeta());
        }
        final EntityMeta entityMeta = new EntityMetaImpl(name, tableMeta, getPath(PACKAGE_ENTITY), getPackage(PACKAGE_ENTITY));
        return entityMeta;
    }

    protected CodeTableMeta readCodeTableMeta(final Scanner scanner, final EntityMeta entityMeta) {
        System.out.print("Is Code Table Entity?(Y or N)(Default 'N'): ");
        final String isCodeTable = scanner.nextLine();
        if (YES.equalsIgnoreCase(isCodeTable)) {
            final CodeTableMetaImpl codeTableMeta = new CodeTableMetaImpl(entityMeta);
            System.out.print("Is Sorted Code Table Entity?(Y or N)(Default 'N'): ");
            final String isSortedCodeTable = scanner.nextLine();
            codeTableMeta.setSorted(YES.equalsIgnoreCase(isSortedCodeTable));
            System.out.print("Javascript file: (Leave empty, if not required): ");
            final String jsFile = scanner.nextLine();
            if (StringUtils.isNotBlank(jsFile)) {
                final CodeTableJSMetaImpl codeTableJSMeta = new CodeTableJSMetaImpl(jsFile, getPath(PATH_JS), codeTableMeta);
                System.out.print("Is Tabbed Layout?(Y or N)(Default 'N'): ");
                codeTableJSMeta.setTabbed(YES.equalsIgnoreCase(scanner.nextLine()));
                codeTableMeta.setJSFileMeta(codeTableJSMeta);
            }
            System.out.print("Sql script file(Leave empty if not required): ");
            final String sqlFile = scanner.nextLine();
            if (StringUtils.isNotBlank(sqlFile)) {
                codeTableMeta.setSqlFileMeta(new CodeTableSqlMetaImpl(sqlFile, getPath(PATH_SQL), codeTableMeta));
            }
            return codeTableMeta;
        }
        return null;
    }

    protected DomainMeta readDomainMeta(final Scanner scanner, final EntityMeta entityMeta) {
        System.out.print("Domain Name: ");
        final String name = scanner.nextLine();
        final DomainMeta domainMeta = new DomainMetaImpl(name, getPath(PACKAGE_DOMAIN), entityMeta, getPackage(PACKAGE_DOMAIN));
        return domainMeta;
    }

    protected ControllerMetaImpl readControllerMeta(final Scanner scanner, final ServiceMeta serviceMeta) {
        System.out.print("Controller Endpoint(Leave empty if Controller is not required): ");
        final String endpoint = scanner.nextLine();
        final ControllerMetaImpl controllerMeta = new ControllerMetaImpl(serviceMeta.getDomainMeta().getName() + "Controller", getPath(PACKAGE_CONTROLLER), getPackage(PACKAGE_CONTROLLER), endpoint, serviceMeta);
        return controllerMeta;
    }

    protected String getPath(final String propertyName) {
        return getPackage(propertyName).replace('.', '\\');
    }

    protected String getPackage(String packageEntity) {
        return getProperty(packageEntity, "");
    }

    private FieldMeta[] getFieldsMeta() {
        final FieldMeta[] fieldMetas = new FieldMeta[3];
        fieldMetas[0] = new FieldMetaImpl("cpxrIdSeq", "Long", "CPXR_ID_SEQ", true, false, false);
        fieldMetas[1] = new FieldMetaImpl("effDtm", "Date", "EFF_DTM", false, true, false);
        fieldMetas[2] = new FieldMetaImpl("endDtm", "Date", "END_DTM", false, false, true);
        return fieldMetas;
    }

}
