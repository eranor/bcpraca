package com.akos.models.services;


import org.antlr.v4.runtime.misc.OrderedHashSet;

import java.util.*;

public class ModuleGraph<T> {
    protected Map<T, Node<T>> nodes = new LinkedHashMap<>();

    public ModuleGraph() {
    }

    public void addEdge(T a, T b) {
        Node<T> a_node = this.getNode(a);
        Node<T> b_node = this.getNode(b);
        a_node.addEdge(b_node);
    }

    public void removeEdge(T a, T b) {
        Node<T> a_node = this.getNode(a);
        Node<T> b_node = this.getNode(b);
        a_node.edges.remove(b_node);
    }

    public Node<T> removeNode(T a) {
        Node<T> existing = this.nodes.get(a);
        if (existing != null) {
            return nodes.remove(existing.content);
        }
        return null;
    }

    protected ModuleGraph.Node<T> getNode(T a) {
        Node<T> existing = this.nodes.get(a);
        if (existing != null) {
            return existing;
        } else {
            Node<T> n = new ModuleGraph.Node<>(a);
            this.nodes.put(a, n);
            return n;
        }
    }

    public List<T> sort() {
        OrderedHashSet visited = new OrderedHashSet();
        ArrayList sorted = new ArrayList();

        while (visited.size() < this.nodes.size()) {
            ModuleGraph.Node n = null;

            for (Object o : this.nodes.values()) {
                Node tNode = (Node) o;
                n = tNode;
                if (!visited.contains(tNode)) {
                    break;
                }
            }

            if (n != null) {
                this.DFS(n, visited, sorted);
            }
        }

        return sorted;
    }

    public void DFS(ModuleGraph.Node<T> n, Set<ModuleGraph.Node<T>> visited, ArrayList<T> sorted) {
        if (!visited.contains(n)) {
            visited.add(n);
            if (n.edges != null) {

                for (Node<T> edge : n.edges) {
                    Node<? extends T> target = edge;
                    this.DFS((Node<T>) target, visited, sorted);
                }
            }

            sorted.add(n.content);
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