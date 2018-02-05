package com.cjs.jworks.generator.dto.impl;

import com.cjs.jworks.generator.dto.base.FileMeta;

public class FileMetaImpl implements FileMeta {
    private final String name;
    private final String content;
    private final String path;

    public FileMetaImpl(String name, String content, String path) {
        this.name = name;
        this.content = content;
        this.path = path;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getPath() {
        return path;
    }
}
