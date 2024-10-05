package me.vvs.graphs;

import java.util.*;

public class UndirectedGraph {
    private Map<String, List<String>> adjList;

    public UndirectedGraph() {
        adjList = new HashMap<>();
    }

    public void addEdge(String src, String dest) {
        if (!adjList.containsKey(src)) adjList.put(src, new ArrayList());
        adjList.get(src).add(dest);
        if (!adjList.containsKey(dest)) adjList.put(dest, new ArrayList());
        adjList.get(dest).add(src);
    }

    public List<String> getNeighbours(String vertex) {
        return adjList.getOrDefault(vertex, Collections.emptyList());
    }

    public String toString() {
        return adjList.toString();
    }

    public Optional<String> getAVertex() {
        Optional<String> firstKeyOptional = adjList.keySet().stream().findFirst();
        return firstKeyOptional;
    }

    public List<String> getAllVertices() {
        return new ArrayList<>(adjList.keySet());
    }
}
