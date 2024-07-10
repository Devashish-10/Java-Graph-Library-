package graph;

import java.util.*;

public class NonWeightGraphAlgorithms {

    public static void dfs(UndirectedGraph graph, int start, Set<Integer> visited) {
        visited.add(start);
        System.out.print(start + " ");
        for (int v : graph.getAdjVertices(start)) {
            if (!visited.contains(v)) {
                dfs(graph, v, visited);
            }
        }
    }

    public static void bfs(UndirectedGraph graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for (int v : graph.getAdjVertices(vertex)) {
                if (!visited.contains(v)) {
                    queue.add(v);
                    visited.add(v);
                }
            }
        }
    }

    public static List<Set<Integer>> connectedComponents(UndirectedGraph graph) {
        List<Set<Integer>> components = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int vertex : graph.getAdjVertices().keySet()) {
            if (!visited.contains(vertex)) {
                Set<Integer> component = new HashSet<>();
                dfs(graph, vertex, visited, component);
                components.add(component);
            }
        }
        return components;
    }

    private static void dfs(UndirectedGraph graph, int vertex, Set<Integer> visited, Set<Integer> component) {
        visited.add(vertex);
        component.add(vertex);
        for (int v : graph.getAdjVertices(vertex)) {
            if (!visited.contains(v)) {
                dfs(graph, v, visited, component);
            }
        }
    }
}
