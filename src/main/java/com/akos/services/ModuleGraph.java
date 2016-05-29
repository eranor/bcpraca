package com.akos.services;


import com.akos.modules.Type;
import com.akos.models.*;

import java.util.*;

public class ModuleGraph {
    protected Map<IModuleModel, Node<IModuleModel>> nodes = new LinkedHashMap<>();

    public ModuleGraph() {
    }

    public void addEdge(IModuleModel a, IModuleModel b) {
        Node<IModuleModel> nodeA = this.getNode(a);
        Node<IModuleModel> nodeB = this.getNode(b);
        nodeA.addEdge(nodeB);
    }

    public void removeEdge(IModuleModel a, IModuleModel b) {
        Node<IModuleModel> nodeA = this.getNode(a);
        Node<IModuleModel> nodeB = this.getNode(b);
        nodeA.edges.remove(nodeB);
    }

    public Node<IModuleModel> removeNode(IModuleModel a) {
        Node<IModuleModel> existing = this.nodes.get(a);
        if (existing != null) {
            return nodes.remove(existing.content);
        }
        return null;
    }

    protected ModuleGraph.Node<IModuleModel> getNode(IModuleModel a) {
        Node<IModuleModel> existing = this.nodes.get(a);
        if (existing != null) {
            return existing;
        } else {
            Node<IModuleModel> n = new ModuleGraph.Node<>(a);
            this.nodes.put(a, n);
            return n;
        }
    }

    private void addLine(String value, List<String> compiled) {
        addLine(value, compiled, "");
    }

    private void addLine(String value, List<String> compiled, Object arg) {
        compiled.add((compiled.size()) + " " + value + (arg.equals("") ? "" : " " + arg));
    }

    public void compile(ModuleGraph.Node<IModuleModel> n, Set<ModuleGraph.Node<IModuleModel>> visited,
                        List<String> compiled, int counter) {

        if (!visited.contains(n)) {
            visited.add(n);
            if (n.edges != null) {
                Type mt = n.content.getType();
                String[] value = n.content.getCompiledValue();
                if (mt == ModuleType.StartModule) {
                    addLine(value[0], compiled);
                    n.edges.forEach(edge -> compile(edge, visited, compiled, compiled.size()+1));
                    if (value.length > 1) {
                        addLine(value[0], compiled, counter);
                    }
                } else if (mt == ModuleType.ForLoopModule) {
                    addLine(value[0], compiled);
                    n.edges.forEach(edge -> compile(edge, visited, compiled, compiled.size()+1));
                    addLine(value[1], compiled);

                } else if (mt == ModuleType.ConditionModule) {

                } else {

                }
            }
            compiled.add(n.content.getCompiledValue()[0]);
        }
    }

    public static class Node<T> {
        T content;
        List<ModuleGraph.Node<T>> edges;

        public Node(T content) {
            this.content = content;
        }

        public void addEdge(ModuleGraph.Node<T> n) {
            if (this.edges == null) {
                this.edges = new ArrayList<>();
            }

            if (!this.edges.contains(n)) {
                this.edges.add(n);
            }

        }

        public String toString() {
            return this.content.toString();
        }
    }
}