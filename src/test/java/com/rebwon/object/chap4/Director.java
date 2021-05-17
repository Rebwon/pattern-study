package com.rebwon.object.chap4;

import java.util.HashMap;
import java.util.Map;

public final class Director {
    private Map<String, Paper> projects = new HashMap<>();

    public void addProject(String name, Paper paper) {
        projects.put(name, paper);
    }

    public void runProject(String name) {
        if(!projects.containsKey(name)) throw new RuntimeException("no project");
        deploy(name, projects.get(name).run());
    }

    private void deploy(String projectName, Program... programs) {}
}
