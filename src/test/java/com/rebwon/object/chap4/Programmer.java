package com.rebwon.object.chap4;

public abstract class Programmer<T extends Paper> {

    public Program getProgram(T paper) {
        setData(paper);
        return makeProgram(paper);
    }

    abstract void setData(T paper);

    abstract Program makeProgram(T paper);
}
