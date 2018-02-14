package com.cjs.jworks.generator.dto.base;

public interface FileMeta {
    String getName();

    String getPath();

    String getContent();

    boolean canAppend();

    void setAppend(boolean append);
}
