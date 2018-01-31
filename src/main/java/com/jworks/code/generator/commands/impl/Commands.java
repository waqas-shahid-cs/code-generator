package com.jworks.code.generator.commands.impl;

public enum Commands {
    GENERATE_CLASSES("generate-classes");

    private final String command;

    Commands(final String command) {
        this.command = command;
    }

    public static Commands findByCommand(final String command) {
        for (final Commands commands : values()) {
            if (commands.command.equals(command)) {
                return commands;
            }
        }
        return null;
    }
}
