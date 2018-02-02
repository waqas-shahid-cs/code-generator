package com.jworks.code.generator.commands.impl;

import com.jworks.code.generator.Configuration;
import com.jworks.code.generator.commands.base.Command;
import com.jworks.code.generator.commands.base.CommandFactory;
import com.jworks.code.generator.commands.base.CommandType;

public final class CommandFactoryImpl extends CommandFactory {

    public CommandFactoryImpl(final Configuration configuration) {
        super(configuration);
    }

    public Command getCommand(final CommandType command) {
        switch (command) {
            case GENERATE_CLASSES:
                return new GenerateClassesCommand();
        }
        return null;
    }
}
