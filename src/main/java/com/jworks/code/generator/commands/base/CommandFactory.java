package com.jworks.code.generator.commands.base;

import com.jworks.code.generator.Configuration;

public abstract class CommandFactory {
    private final Configuration configuration;

    public CommandFactory(final Configuration configuration) {
        this.configuration = configuration;
    }

    public abstract Command getCommand(final CommandType command);
}
