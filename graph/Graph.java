package graph;

import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjVertices;

    public Graph() {
        this.adjVertices = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjVertices.put(vertex, new ArrayList<>());
    }

    public void addEdge(int source, int destination) {
        adjVertices.get(source).add(destination);
        adjVertices.get(destination).add(source);
    }

    public List<Integer> getVertices() {
        return new ArrayList<>(adjVertices.keySet());
    }

    public List<Integer> getAdjVertices(int vertex) {
        return new ArrayList<>(adjVertices.get(vertex));
    }

    public Map<Integer, List<Integer>> getAdjVerticesMap() {
        return adjVertices;
    }
}
