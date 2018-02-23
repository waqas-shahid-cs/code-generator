package com.cjs.jworks.generator.context;

import com.cjs.jworks.generator.command.base.CommandFactory;
import com.cjs.jworks.generator.db.base.DBManager;
import com.cjs.jworks.generator.generator.base.GeneratorFactory;
import com.cjs.jworks.generator.template.base.TemplateResolver;

import java.io.File;
import java.util.Properties;

public interface Context {
    CommandFactory getCommandFactory();

    GeneratorFactory getGeneratorFactory();

    Properties getProperties();

    TemplateResolver getTemplateResolver();

    DBManager getDbManager() throws ClassNotFoundException;

    File getProjectFolder();
}
