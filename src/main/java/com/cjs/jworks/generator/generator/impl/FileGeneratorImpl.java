package com.cjs.jworks.generator.generator.impl;

import com.cjs.jworks.generator.dto.base.FileMeta;
import com.cjs.jworks.generator.generator.base.FileGenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileGeneratorImpl implements FileGenerator {
    @Override
    public File generate(final FileMeta fileMeta) throws Exception {
        if (fileMeta != null) {
            final File folder = new File(fileMeta.getPath());
            if (!folder.exists()) {
                throw new IOException("The system cannot find the path specified: " + folder.getAbsolutePath());
            }
            final File file = folder.isDirectory() ? new File(folder, fileMeta.getName()) : folder;
            boolean isNew = false;
            if (!file.exists()) {
                file.createNewFile();
                isNew = true;
            }
            if (isNew || fileMeta.canAppend()) {
                try (final FileWriter writer = new FileWriter(file, fileMeta.canAppend())) {
                    writer.write(fileMeta.getContent());
                }
            }
            return file;
        }
        return null;
    }
}
