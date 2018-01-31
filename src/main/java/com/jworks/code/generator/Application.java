package com.jworks.code.generator;

import com.jworks.code.generator.commands.impl.Commands;
import org.apache.commons.lang3.ArrayUtils;

public class Application {

    public static void main(final String[] args) {
        if (ArrayUtils.isNotEmpty(args)) {
            final Commands command = Commands.findByCommand(args[0]);
            if (command != null) {

            }
        }
    }
}
