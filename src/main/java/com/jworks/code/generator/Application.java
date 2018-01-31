package com.jworks.code.generator;

import com.jworks.code.generator.commands.base.CommandType;
import org.apache.commons.lang3.ArrayUtils;

public class Application {

    public static void main(final String[] args) {
        if (ArrayUtils.isNotEmpty(args)) {
            final CommandType command = CommandType.findByCommand(args[0]);
            if (command != null) {

            }
        }
    }
}
