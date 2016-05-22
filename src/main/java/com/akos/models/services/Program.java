package com.akos.models.services;


import com.akos.models.modules.*;
import com.akos.models.modules.StartModuleModel.StartSetting;
import javafx.util.Pair;

import java.util.*;

/**
 * Created by Ákos on 2015. 12. 07.
 * Email: akoshervay@gmail.com
 */

public class Program implements IProgram, Comparable {

    private final UUID id = UUID.randomUUID();
    private String name;
    private List<IModuleModel> elements;
    private List<IModuleModel> startNodes = new ArrayList<>();
    private ModuleGraph<IModuleModel> moduleGraph = new ModuleGraph<>();

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

    public void makeConnection(IModuleModel element1, IModuleModel element2) {
        moduleGraph.addEdge(element1, element2);
    }

    public Pair<IModuleModel, IModuleModel> removeEdge(IModuleModel element1, IModuleModel element2) {
        moduleGraph.removeEdge(element1, element2);
        return new Pair<>(element1, element2);
    }

    private void append(String[] sa, StringBuilder sb) {
        for (String s : sa) {
            sb.append(String.valueOf(counter++)).append(" ").append(s).append("\n");
        }
    }

    public String compile() {
        return compile((StartModuleModel) startNodes.get(0));
    }

    public String compile(StartModuleModel startNode) {
        StringBuilder sb = new StringBuilder();
        String startCounter = String.valueOf(counter);
        boolean isLoop = startNode.getSetting() == StartSetting.LOOP;
        List<IModuleModel> sorted = new ArrayList<>();
        Set<ModuleGraph.Node<IModuleModel>> visited = new LinkedHashSet<>();
        moduleGraph.DFS(moduleGraph.getNode(startNodes.get(0)), visited, (ArrayList<IModuleModel>) sorted);
        visited.forEach(iModuleModelNode -> append(iModuleModelNode.content.getCompiledValue(), sb));
        if (isLoop)
            append(new String[]{"goto " + startCounter}, sb);
        return sb.toString();
    }

    public void test() {
        List<IModuleModel> sorted = new ArrayList<>();
        Set<ModuleGraph.Node<IModuleModel>> visited = new LinkedHashSet<>();
        moduleGraph.DFS(moduleGraph.getNode(startNodes.get(0)), visited, (ArrayList<IModuleModel>) sorted);
        System.out.println(Arrays.toString(sorted.toArray()));
        visited.forEach(System.out::println);
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

    public ModuleGraph<IModuleModel> getModuleGraph() {
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
