package com.akos.services;


import com.akos.modules.*;
import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Ákos on 2015. 12. 07.
 * Email: akoshervay@gmail.com
 */

public class Program implements Comparable {

    private final UUID id = UUID.randomUUID();
    private String name;
    private List<IModuleModel> elements;
    private List<IModuleModel> startNodes = new ArrayList<>();
    private ModuleGraph moduleGraph = new ModuleGraph();

    private int counter = 1;

    public Program(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void updateElements(IModuleModel module) {
        this.elements.add(module);
        if (module.getType() == ModuleType.StartModule) {
            this.startNodes.add(module);
        }
    }

    public void makeConnection(int prio1, IModuleModel element1, int prio2, IModuleModel element2) {
        moduleGraph.addEdge(prio2, element1, prio1, element2);
    }

    public Pair<IModuleModel, IModuleModel> removeEdge(IModuleModel element1, IModuleModel element2) {
        moduleGraph.removeEdge(element1, element2);
        return new Pair<>(element1, element2);
    }

    public String compile() {
        if (startNodes.size() > 0) {
            List<String> compiled = moduleGraph.compile(moduleGraph.getNode(startNodes.get(0)));
            return compiled.stream().collect(Collectors.joining("\n"));
        }
        return "";
    }

    public UUID getId() {
        return id;
    }

    public List<IModuleModel> getElements() {
        return elements;
    }

    public void setElements(List<IModuleModel> elements) {
        this.elements = elements;
    }

    public ModuleGraph getModuleGraph() {
        return moduleGraph;
    }

    @Override
    public int compareTo(Object o) {
        int idCheck = this.getId() == ((Program) o).getId() ? 1 : 0;
        int nameCheck = this.getName().compareTo(((Program) o).getName());
        return idCheck + nameCheck;
    }

    @Override
    public String toString() {
        return String.format("Program: %s", name);
    }
}
