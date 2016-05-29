package com.akos.services;


import com.akos.models.*;
import com.akos.modules.Type;

import java.util.*;

public class ModuleGraph {
    protected Map<IModuleModel, Node<IModuleModel>> nodes = new LinkedHashMap<>();

    public ModuleGraph() {
    }

    public void addEdge(int prio1, IModuleModel a, int prio2, IModuleModel b) {
        Node<IModuleModel> nodeA = this.getNode(prio1, a);
        Node<IModuleModel> nodeB = this.getNode(prio2, b);
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
        }
        return null;
    }

    protected ModuleGraph.Node<IModuleModel> getNode(int prio, IModuleModel a) {
        Node<IModuleModel> existing = this.nodes.get(a);
        if (existing != null) {
            return existing;
        } else {
            Node<IModuleModel> n = new ModuleGraph.Node<>(prio, a);
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
                    n.edges.forEach(edge -> compile(edge, visited, compiled, compiled.size() + 1));
                    if (value.length > 1) {
                        addLine(value[0], compiled, counter);
                    }
                } else if (mt == ModuleType.ForLoopModule) {
                    addLine(value[0], compiled);
                    n.edges.forEach(edge -> compile(edge, visited, compiled, compiled.size() + 1));
                    addLine(value[1], compiled);
                } else if (mt == ModuleType.ConditionModule) {

                } else {

                }
            }
            compiled.add(n.content.getCompiledValue()[0]);
        }
    }


    void DFSUtil(ModuleGraph.Node<IModuleModel> n, Set<ModuleGraph.Node<IModuleModel>> visited) {
        if (!visited.contains(n)) {
            visited.add(n);
            for (Node<IModuleModel> iModuleModelNode : nodes.values()) {
                n = iModuleModelNode;
                if (!visited.contains(n))
                    DFSUtil(n, visited);
            }
        }
    }

    private ModuleGraph getTranspose() {
        ModuleGraph g = new ModuleGraph();
        for (IModuleModel i : nodes.keySet()) {
            for (Node j : nodes.get(i).edges) {
                g.addEdge(0, (IModuleModel) j.content, 0, i);
            }
        }
        return g;
    }


    public static class Node<T> implements Comparable<Node<T>> {
        private final int priority;
        private T content;
        private TreeSet<Node<T>> edges;

        public Node(int priority, T content) {
            this.content = content;
            this.priority = priority;
        }

        public void addEdge(ModuleGraph.Node<T> n) {
            if (this.edges == null) {
                this.edges = new TreeSet<>();
            }

            if (!this.edges.contains(n)) {
                this.edges.add(n);
            }

        }

        @Override
        public int compareTo(Node<T> o) {
            return (priority < o.priority) ? -1 : (priority > o.priority) ? 1 : 0;
        }

        public String toString() {
            return this.content.toString();
        }
    }
}