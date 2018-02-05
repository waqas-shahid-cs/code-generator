package com.cjs.jworks.generator.generator.base;

public interface Generator<P, R> {
    R generate(P args) throws Exception;
}
