package com.cjs.jworks.generator.util;

import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public final class FileUtils {
    private FileUtils() {
    }

    public static File searchFile(String filePath) throws IOException {
        if (StringUtils.isNotBlank(filePath)) {
            filePath = filePath.replace("/", "\\");
            final Collection<File> files = org.apache.commons.io.FileUtils.listFilesAndDirs(getCurrentDirectory(), TrueFileFilter.INSTANCE, DirectoryFileFilter.INSTANCE);
            for (File file : files) {
                if (file.getAbsolutePath().endsWith(filePath)) {
                    return file;
                }
            }
        }
        return null;
    }

    public static File getCurrentDirectory() throws IOException {
        return new File(".").getCanonicalFile().getParentFile();
    }

    public static String searchDirectory(String filePath) throws IOException {
        if (StringUtils.isNotBlank(filePath)) {
            filePath = filePath.replace("/", "\\");
            final File currentFolder = getCurrentDirectory();
            final Collection<File> folders = org.apache.commons.io.FileUtils.listFilesAndDirs(currentFolder, new NotFileFilter(TrueFileFilter.INSTANCE), DirectoryFileFilter.INSTANCE);
            for (final File folder : folders) {
                if (folder.getAbsolutePath().endsWith(filePath)) {
                    return folder.getAbsolutePath();
                }
            }
        }
        return null;
    }
}
