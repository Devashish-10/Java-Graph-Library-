package weightedgraph;

import java.util.*;

public class WeightedGraph {
    private Map<Integer, List<Edge>> adjVertices;

    public WeightedGraph() {
        this.adjVertices = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjVertices.put(vertex, new ArrayList<>());
    }

    public void addEdge(int source, int destination, int weight) {
        adjVertices.get(source).add(new Edge(destination, weight));
        adjVertices.get(destination).add(new Edge(source, weight)); // For undirected graph
    }

    public List<Integer> getVertices() {
        return new ArrayList<>(adjVertices.keySet());
    }

    public List<Edge> getAdjVertices(int vertex) {
        return new ArrayList<>(adjVertices.get(vertex));
    }

    public Map<Integer, List<Edge>> getAdjVerticesMap() {
        return adjVertices;
    }

    public int getWeight(int source, int destination) {
        for (Edge edge : adjVertices.get(source)) {
            if (edge.destination == destination) {
                return edge.weight;
            }
        }
        return Integer.MAX_VALUE; // or handle as per your logic
    }

    static class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
}
