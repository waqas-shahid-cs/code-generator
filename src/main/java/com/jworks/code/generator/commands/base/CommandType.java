package com.jworks.code.generator.commands.base;

public enum CommandType {
    GENERATE_CLASSES("generate-classes");

    private final String commandType;

    CommandType(final String commandType) {
        this.commandType = commandType;
    }

    public static CommandType findByCommand(final String commandType) {
        for (final CommandType command : values()) {
            if (command.commandType.equals(commandType)) {
                return command;
            }
        }
        return null;
    }
}
