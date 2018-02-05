package com.cjs.jworks.generator.command.impl;

import com.cjs.jworks.generator.command.base.ContextCommand;
import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.*;
import com.cjs.jworks.generator.dto.impl.*;

import java.io.File;
import java.util.Scanner;

public class GenerateClassesCommand extends ContextCommand {
    private static final String PACKAGE_ENTITY = "package.entity";
    private static final String PACKAGE_DOMAIN = "package.domain";

    public GenerateClassesCommand(final Context context) {
        super(context);
    }

    public void execute() throws Exception {
        try (final Scanner scanner = new Scanner(System.in)) {
            final EntityMeta entityMeta = readEntityMeta(scanner);
            final DomainMeta domainMeta = readDomainMeta(scanner, entityMeta);
            final File entityFile = getFactory().getEntityGenerator().generate(entityMeta);
            if (entityFile != null && entityFile.exists()) {
                System.out.println("Entity has been generated.");
                getFactory().getDomainGenerator().generate(domainMeta);
                System.out.println("Domain has been generated.");

                final RepositoryMeta repositoryMeta = new RepositoryMetaImpl(entityMeta.getName() + "Repository", getProperty("package.repository", ""), entityMeta);
                getFactory().getRepositoryGenerator().generate(repositoryMeta);
                System.out.println("Repository has been generated.");

                final ServiceMeta serviceMeta = new ServiceMetaImpl(entityMeta, domainMeta, repositoryMeta);
                getFactory().getServiceGenerator().generate(serviceMeta);
                System.out.println("Service has been generated.");
            }
        }
    }

    public EntityMeta readEntityMeta(final Scanner scanner) {
        System.out.print("Please provide the Entity Name: ");
        final String name = scanner.nextLine();
        System.out.print("Please provide the Table Name: ");
        final String table = scanner.nextLine();
        final EntityMetaImpl entityMeta = new EntityMetaImpl(name, table, getProperty(PACKAGE_ENTITY, ""));
        entityMeta.setFieldsMeta(getFieldsMeta(entityMeta));
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
        final DomainMeta domainMeta = new DomainMetaImpl(name, getProperty(PACKAGE_DOMAIN, ""), entityMeta);
        return domainMeta;
    }
}
