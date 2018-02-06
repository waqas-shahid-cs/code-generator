package com.cjs.jworks.generator.context;

import com.cjs.jworks.generator.command.base.CommandFactory;
import com.cjs.jworks.generator.command.impl.CommandFactoryImpl;
import com.cjs.jworks.generator.db.base.DBManager;
import com.cjs.jworks.generator.db.impl.DBManagerImpl;
import com.cjs.jworks.generator.generator.base.GeneratorFactory;
import com.cjs.jworks.generator.generator.impl.GeneratorFactoryImpl;
import com.cjs.jworks.generator.template.base.TemplateResolver;
import com.cjs.jworks.generator.template.impl.StringTemplateResolver;

import java.util.Properties;

public class ContextImpl implements Context {

    private Properties properties = new Properties();

    @Override
    public CommandFactory getCommandFactory() {
        return new CommandFactoryImpl(this);
    }

    @Override
    public GeneratorFactory getGeneratorFactory() {
        return new GeneratorFactoryImpl(this);
    }

    @Override
    public Properties getProperties() {
        return properties;
    }

    @Override
    public TemplateResolver getTemplateResolver() {
        return new StringTemplateResolver(this);
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public DBManager getDbManager() throws ClassNotFoundException {
        return new DBManagerImpl(this);
    }
}
