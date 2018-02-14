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
    private static final String PACKAGE_ENTITY = "package.entity";
    private static final String PACKAGE_DOMAIN = "package.domain";
    private static final String YES = "Y";
    private static final String PACKAGE_REPOSITORY = "package.repository";
    private static final String PATH_SQL = "path.sql";

    public GenerateClassesCommand(final Context context) {
        super(context);
    }

    public void execute() throws Exception {
        try (final Scanner scanner = new Scanner(System.in)) {
            final EntityMetaImpl entityMeta = readEntityMeta(scanner);
            final DomainMeta domainMeta = readDomainMeta(scanner, entityMeta);
            fillFieldsMeta(entityMeta);
            final CodeTableMeta codeTableMeta = readCodeTableMeta(scanner, entityMeta);
            File entityFile;
            if (codeTableMeta != null) {
                entityFile = getContext().getGeneratorFactory().getCodeTableFeatureGenerator().generate(codeTableMeta);
            } else {
                entityFile = getContext().getGeneratorFactory().getEntityGenerator().generate(entityMeta);
            }


            if (entityFile != null && entityFile.exists()) {
                System.out.println("Entity has been generated.");
                getFactory().getDomainGenerator().generate(domainMeta);
                System.out.println("Domain has been generated.");

                final RepositoryMeta repositoryMeta = new RepositoryMetaImpl(entityMeta.getName() + "Repository", getPath(PACKAGE_REPOSITORY), entityMeta, getPackage(PACKAGE_REPOSITORY));
                getFactory().getRepositoryGenerator().generate(repositoryMeta);
                System.out.println("Repository has been generated.");

                final ServiceMeta serviceMeta = new ServiceMetaImpl(domainMeta.getName() + "Service", domainMeta.getName() + "ServiceImpl", entityMeta, domainMeta, repositoryMeta);
                getFactory().getServiceGenerator().generate(serviceMeta);
                System.out.println("Service has been generated.");
            }
        }
    }

    public EntityMetaImpl readEntityMeta(final Scanner scanner) {
        System.out.print("Please provide the Entity Name: ");
        final String name = scanner.nextLine();
        System.out.print("Please provide the Table Name: ");
        final String table = scanner.nextLine();
        final EntityMetaImpl entityMeta = new EntityMetaImpl(name, table, getPath(PACKAGE_ENTITY), getPackage(PACKAGE_ENTITY));
        return entityMeta;
    }

    public CodeTableMeta readCodeTableMeta(final Scanner scanner, final EntityMeta entityMeta) {
        System.out.print("Is Code Table Entity?(Y or N)(Default 'N'): ");
        final String isCodeTable = scanner.nextLine();
        if (YES.equals(isCodeTable) || YES.toLowerCase().equals(isCodeTable)) {
            final CodeTableMetaImpl codeTableMeta = new CodeTableMetaImpl(entityMeta);
            System.out.print("Is Sorted Code Table Entity?(Y or N)(Default 'N'): ");
            final String isSortedCodeTable = scanner.nextLine();
            codeTableMeta.setSorted(YES.equals(isSortedCodeTable) || YES.toLowerCase().equals(isSortedCodeTable));
            System.out.print("Please enter the sql script file(Leave empty if not required): ");
            final String sqlFile = scanner.nextLine();
            if (StringUtils.isNotBlank(sqlFile)) {
                codeTableMeta.setSqlFileMeta(new SqlFileMetaImpl(sqlFile, getPath(PATH_SQL)));
            }
            return codeTableMeta;
        }
        return null;
    }

    protected String getPath(final String propertyName) {
        return getPackage(propertyName).replace('.', '\\');
    }

    protected String getPackage(String packageEntity) {
        return getProperty(packageEntity, "");
    }

    private EntityMetaImpl fillFieldsMeta(final EntityMetaImpl entityMeta) throws Exception {
        //entityMeta.setFieldsMeta(getFieldsMeta(entityMeta));
        try {
            entityMeta.setFieldsMeta(getContext().getDbManager().getTableFields(entityMeta.getTable()));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return entityMeta;
    }

    private FieldMeta[] getFieldsMeta(final EntityMeta entityMeta) {
        final FieldMeta[] fieldMetas = new FieldMeta[3];
        fieldMetas[0] = new FieldMetaImpl("cpxrIdSeq", "Long", "CPXR_ID_SEQ", true, false, false);
        fieldMetas[1] = new FieldMetaImpl("effDtm", "Date", "EFF_DTM", false, true, false);
        fieldMetas[2] = new FieldMetaImpl("endDtm", "Date", "END_DTM", false, false, true);
        return fieldMetas;
    }

    public DomainMeta readDomainMeta(final Scanner scanner, final EntityMeta entityMeta) {
        System.out.print("Please provide the Domain Name: ");
        final String name = scanner.nextLine();
        final DomainMeta domainMeta = new DomainMetaImpl(name, getPath(PACKAGE_DOMAIN), entityMeta, getPackage(PACKAGE_DOMAIN));
        return domainMeta;
    }
}
