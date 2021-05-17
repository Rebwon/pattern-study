package com.rebwon.object.chap4;

public abstract class FrontEnd<T extends Paper> extends Programmer<T> {
    protected Language language;
    protected Library library;

    @Override
    protected Program makeProgram(T paper) {
        return new Program();
    }
}
