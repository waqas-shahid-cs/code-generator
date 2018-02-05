package com.cjs.jworks.generator.command.base;

import com.cjs.jworks.generator.context.Context;

public abstract class CommandFactory {
    private final Context context;

    public CommandFactory(final Context context) {
        this.context = context;
    }

    protected Context getContext() {
        return context;
    }

    public abstract Command getCommand(final CommandType command);
}
