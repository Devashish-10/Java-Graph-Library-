import graph.*;
import weightedgraph.*;

import java.util.*;

public class GraphLibraryDemo {
    public static void main(String[] args) {
        // Create an undirected graph
        UndirectedGraph undirectedGraph = new UndirectedGraph();
        for (int i = 0; i < 5; i++) {
            undirectedGraph.addVertex(i);
        }
        undirectedGraph.addEdge(0, 1);
        undirectedGraph.addEdge(0, 2);
        undirectedGraph.addEdge(1, 2);
        undirectedGraph.addEdge(1, 3);
        undirectedGraph.addEdge(2, 4);

        // Perform DFS
        System.out.println("DFS:");
        Set<Integer> visitedDFS = new HashSet<>();
        NonWeightGraphAlgorithms.dfs(undirectedGraph, 0, visitedDFS);

        // Perform BFS
        System.out.println("\nBFS:");
        NonWeightGraphAlgorithms.bfs(undirectedGraph, 0);

        // Check for connected components
        System.out.println("\nConnected Components:");
        List<Set<Integer>> components = NonWeightGraphAlgorithms.connectedComponents(undirectedGraph);
        for (Set<Integer> component : components) {
            System.out.println(component);
        }

        // Create a weighted graph
        WeightedGraph weightedGraph = new WeightedGraph();
        for (int i = 0; i < 5; i++) {
            weightedGraph.addVertex(i);
        }
        weightedGraph.addEdge(0, 1, 4);
        weightedGraph.addEdge(0, 2, 1);
        weightedGraph.addEdge(1, 2, 2);
        weightedGraph.addEdge(1, 3, 5);
        weightedGraph.addEdge(2, 3, 8);
        weightedGraph.addEdge(2, 4, 10);
        weightedGraph.addEdge(3, 4, 2);

        // Perform Dijkstra's algorithm
        System.out.println("\nDijkstra's Algorithm:");
        Map<Integer, Integer> distances = WeightedGraphAlgorithms.dijkstra(weightedGraph, 0);
        for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
            System.out.println("Distance from 0 to " + entry.getKey() + " is " + entry.getValue());
        }

        // Perform Kruskal's MST algorithm
        System.out.println("\nKruskal's MST Algorithm:");
        List<int[]> mst = WeightedGraphAlgorithms.kruskalMST(weightedGraph);
        for (int[] edge : mst) {
            System.out.println("Edge: " + edge[0] + " - " + edge[1] + " weight: " + edge[2]);
        }
    }
}
