package com.rebwon.toy1;

public final class Main {

    public static void main(String[] args) {
        Dispatch dispatch = new Dispatch();
        System.out.println(dispatch.method());
//        DynamicDispatch dispatch = new DispatchImpl();
//        System.out.println(dispatch.some());
    }
}

class Dispatch {
    public String method() {
        return "Hello Spring";
    }
}

class DispatchImpl implements DynamicDispatch {

    @Override
    public String some() {
        return "Hello Dispatch";
    }
}

interface DynamicDispatch {
    String some();
}