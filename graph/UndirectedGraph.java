package graph;

import java.util.*;

public class UndirectedGraph {

    private Map<Integer, List<Integer>> adjVertices;

    public UndirectedGraph() {
        this.adjVertices = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjVertices.put(vertex, new ArrayList<>());
    }

    public void addEdge(int src, int dest) {
        adjVertices.get(src).add(dest);
        adjVertices.get(dest).add(src);
    }

    public List<Integer> getAdjVertices(int vertex) {
        return adjVertices.get(vertex);
    }

    public Map<Integer, List<Integer>> getAdjVertices() {
        return adjVertices;
    }
}
