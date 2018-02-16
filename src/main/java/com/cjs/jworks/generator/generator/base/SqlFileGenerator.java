package com.cjs.jworks.generator.generator.base;

import com.cjs.jworks.generator.dto.base.SqlFileMeta;

import java.io.File;

public interface SqlFileGenerator<P extends SqlFileMeta> extends Generator<P, File> {
}
