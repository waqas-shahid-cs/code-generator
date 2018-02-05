package com.cjs.jworks.generator.command.impl;

import com.cjs.jworks.generator.command.base.Command;
import com.cjs.jworks.generator.command.base.CommandFactory;
import com.cjs.jworks.generator.command.base.CommandType;
import com.cjs.jworks.generator.context.Context;

public final class CommandFactoryImpl extends CommandFactory {

    public CommandFactoryImpl(final Context context) {
        super(context);
    }

    public Command getCommand(final CommandType command) {
        switch (command) {
            case GENERATE_CLASSES:
                return new GenerateClassesCommand(getContext());
        }
        return null;
    }
}
