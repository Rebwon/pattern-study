package com.rebwon.object.chap4;

public abstract class ServerClient implements Paper {
    Server server = new Server("test");
    Language backendLanguage = new Language("java");
    Language frontendLanguage = new Language("kotlinJS");

    Programmer backendProgrammer;
    Programmer frontendProgrammer;
}
