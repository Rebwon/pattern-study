package com.rebwon.object.chap4;

public final class App {

    public static void main(String[] args) {
        Director director = new Director();
        director.addProject("여행사 A 프론트 개편", new Client() {
            @Override
            public Program[] run() {
                FrontEnd frontEnd = new FrontEnd<Client>() {
                    @Override
                    void setData(Client paper) {
                        library = paper.library;
                        language = paper.language;
                    }
                };
                programmer = frontEnd;  // 정보 은닉까지 지켜냈다.
                return new Program[]{frontEnd.getProgram(this)};
            }
        });
        director.runProject("여행사 A 프론트 개편");

        director.addProject("쿠팡 A 프론트 백엔드 개편", new ServerClient() {
            @Override
            public Program[] run() {
                FrontEnd frontEnd = new FrontEnd<ServerClient>() {

                    @Override
                    void setData(ServerClient paper) {
                        language = paper.frontendLanguage;
                    }
                };

                BackEnd backEnd = new BackEnd<ServerClient>() {

                    @Override
                    void setData(ServerClient paper) {
                        server = paper.server;
                        language = paper.backendLanguage;
                    }
                };

                frontendProgrammer = frontEnd;
                backendProgrammer = backEnd;

                return new Program[]{frontEnd.getProgram(this), backEnd.getProgram(this)};
            }
        });
    }
}
