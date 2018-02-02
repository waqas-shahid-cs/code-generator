package com.jworks.code.generator.commands.impl;

import com.jworks.code.generator.commands.base.Command;
import com.jworks.code.generator.dto.base.ClassMeta;
import com.jworks.code.generator.dto.base.DomainMeta;
import com.jworks.code.generator.dto.base.EntityMeta;

import java.util.Scanner;

public class GenerateClassesCommand implements Command {

    public void execute() {
        final ClassMetaImpl classMeta = new ClassMetaImpl();
        try (final Scanner scanner = new Scanner(System.in)) {
            classMeta.setEntityMeta(readEntityMeta(scanner));
            classMeta.setDomainMeta(readDomainMeta(scanner));
        }
    }

    public EntityMeta readEntityMeta(final Scanner scanner) {
        final EntityMetaImpl entityMeta = new EntityMetaImpl();
        System.out.print("Please provide the Entity Name: ");
        entityMeta.setName(scanner.nextLine());
        System.out.print("Please provide the Table Name: ");
        entityMeta.setTable(scanner.nextLine());
        return entityMeta;
    }

    public DomainMeta readDomainMeta(final Scanner scanner) {
        final DomainMetaImpl domainMeta = new DomainMetaImpl();
        System.out.print("Please provide the Domain Name: ");
        domainMeta.setName(scanner.nextLine());
        return domainMeta;
    }

    private static class ClassMetaImpl implements ClassMeta {
        private EntityMeta entityMeta;
        private DomainMeta domainMeta;

        @Override
        public EntityMeta getEntityMeta() {
            return entityMeta;
        }

        public void setEntityMeta(EntityMeta entityMeta) {
            this.entityMeta = entityMeta;
        }

        @Override
        public DomainMeta getDomainMeta() {
            return domainMeta;
        }

        public void setDomainMeta(DomainMeta domainMeta) {
            this.domainMeta = domainMeta;
        }
    }

    private static class EntityMetaImpl implements EntityMeta {
        private String name;
        private String table;

        @Override
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String getTable() {
            return table;
        }

        public void setTable(String table) {
            this.table = table;
        }
    }

    private static class DomainMetaImpl implements DomainMeta {
        private String name;

        @Override
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
