package me.vvs.graphs.bfs;

import java.util.*;

import me.vvs.graphs.UndirectedGraph;

public class BFS {

    /**
     * BFS from a source vertex
     *
     * @param ug
     * @param src
     */
    public void doBfsFromSource(UndirectedGraph ug, String src) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(src);
        queue.add(src);
        while (!queue.isEmpty()) {
            String currVertex = queue.poll();
            System.out.println(currVertex);
            for (String neighbour : ug.getNeighbours(currVertex)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
    }

    public void doBfsForAllVertices(UndirectedGraph ug) {
        Set<String> visited = new HashSet<>();
        for (String vertex : ug.getAllVertices()) {
            if (!visited.contains(vertex)) {
                doBfs(ug, visited, vertex);
            }
        }

    }

    private void doBfs(UndirectedGraph ug, Set<String> visited, String vertex) {
        Queue<String> queue = new LinkedList<>();
        queue.add(vertex);
        visited.add(vertex);
        while (!queue.isEmpty()) {
            String currVertex = queue.poll();
            System.out.println(currVertex);
            for (String neighbour : ug.getNeighbours(currVertex)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
    }

    public static void main(String[] args) {
        UndirectedGraph ug = new UndirectedGraph();
        ug.addEdge("1", "2");
        ug.addEdge("1", "3");
        ug.addEdge("1", "4");
        System.out.println(ug);

        BFS bfs = new BFS();
//        bfs.doBfs(ug, "1");
        ug.addEdge("5", "6");
//        bfs.doBfsFromSource(ug, "5");
        bfs.doBfsForAllVertices(ug);
    }
}
