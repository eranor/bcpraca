package com.akos.services;


import com.akos.modules.*;
import com.akos.modules.specific.EndModuleModel;
import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

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

    private void addLine(String value, List<String> compiled, java.io.Serializable arg) {
        compiled.add((compiled.size() + 1) * 10 + " " + value + (arg.equals("") ? "" : " " + arg));
    }

    public List<String> compile(ModuleGraph.Node<IModuleModel> n) {
        ArrayList<String> strings = new ArrayList<>();
        compile(n, new HashSet<>(), strings, 1, new Stack<>());
        return strings;
    }

    public void compile(ModuleGraph.Node<IModuleModel> n, Set<ModuleGraph.Node<IModuleModel>> visited,
                        List<String> compiled, int counter, Stack<Pair<String, Integer>> stack) {
        Type mt = n.content.getType();
        String[] value = n.content.getCompiledValue();
        if (!visited.contains(n)) {
            visited.add(n);
            List<Node<IModuleModel>> edges = null;
            if (n.edges != null && n.edges.size() > 0) {
                edges = n.edges.stream().sorted((o1, o2) ->
                        (o1.priority < o2.priority) ? -1 : (o1.priority > o2.priority) ? 1 : 0)
                        .collect(Collectors.toList());
            }
            if (n.content instanceof EndModuleModel) {
                addLine(n.content.getCompiledValue()[0], compiled);
            }
            if (edges != null) {
                if (mt == ModuleType.StartModule) {
                    addLine(value[0], compiled);
                    edges.forEach(edge -> compile(edge, visited, compiled, compiled.size() + 1, stack));
                    if (value.length > 1)
                        addLine(value[1], compiled);
                } else if (mt == ModuleType.ForLoopModule) {
                    addLine(value[0], compiled);
                    compile(edges.get(0), visited, compiled, compiled.size() + 1, stack);
                    addLine(value[1], compiled);
                    compile(edges.get(1), visited, compiled, compiled.size() + 1, stack);
                } else if (mt == ModuleType.EndIfModule) {
                    stack.add(new Pair<>("if", counter));
                    edges.forEach(edge -> compile(edge, visited, compiled, compiled.size() + 1, stack));
                } else if (mt == ModuleType.ConditionModule) {
                    addLine(value[0] + "goto " + (counter + 1) * 10, compiled);
                    stack.add(new Pair<>("if", counter));
                    edges.forEach(edge -> compile(edge, visited, compiled, compiled.size() + 1, stack));
                    final int rel1 = stack.pop().getValue() * 10;
                    final int if_start = stack.pop().getValue();
                    compiled.set(if_start - 1, compiled.get(if_start - 1) + " else goto " + (rel1));
                    compiled.add(rel1 / 10 - 1, (rel1 - 1) + " goto " + (compiled.size() + 1) * 10);
                } else if (mt == ModuleType.WhileLoopModule) {
                    addLine(value[0] + " goto " + (counter + 1) * 10, compiled);
                    stack.add(new Pair<>("while", counter));
                    compile(edges.get(0), visited, compiled, compiled.size() + 1, stack);
                    final int if_start = stack.pop().getValue();
                    final int rel1 = (compiled.size() + 1) * 10;
                    compiled.set(if_start - 1, compiled.get(if_start - 1) + " else goto " + (rel1 + 10));
                    compiled.add(rel1 + " goto " + if_start * 10);
                    compile(edges.get(1), visited, compiled, compiled.size() + 1, stack);
                } else {
                    addLine(value[0], compiled);
                    edges.forEach(edge -> compile(edge, visited, compiled, compiled.size() + 1, stack));
                }
            }
        }

    }

    public static class Node<T> implements Comparable<Node<T>> {
        private final int priority;
        private T content;
        private Set<Node<T>> edges;

        public Node(int priority, T content) {
            this.content = content;
            this.priority = priority;
        }

        public void addEdge(ModuleGraph.Node<T> n) {
            if (this.edges == null) {
                this.edges = new HashSet<>();
            }

            if (!this.edges.contains(n)) {
                this.edges.add(n);
            }

        }


        public String toString() {
            return this.content.toString();
        }

        @Override
        public int compareTo(Node<T> o) {
            return this.content == o.content ? 0 : 1;
        }
    }
}