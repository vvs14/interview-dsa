package me.vvs.graphs;

import java.util.*;

public class DirectedGraph {

    private Map<String, List<String>> adjList;

    public DirectedGraph() {
        adjList = new HashMap<>();
    }

    public void addEdge(String src, String dest) {
        if (!adjList.containsKey(src)) adjList.put(src, new ArrayList());
        adjList.get(src).add(dest);
    }

    public List<String> getNeighbours(String vertex) {
        return adjList.getOrDefault(vertex, Collections.emptyList());
    }

    public String toString() {
        return adjList.toString();
    }

    public Optional<String> getAVertex() {
        return adjList.keySet().stream().findFirst();
    }

    public List<String> getAllVertices() {
        return new ArrayList<>(adjList.keySet());
    }
}
