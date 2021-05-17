package com.rebwon.object.chap4;

public abstract class BackEnd<T extends Paper> extends Programmer<T> {
    protected Server server;
    protected Language language;

    @Override
    protected Program makeProgram(Paper paper) {
        return new Program();
    }
}
