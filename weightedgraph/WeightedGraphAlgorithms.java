package weightedgraph;

import java.util.*;

public class WeightedGraphAlgorithms {

    public static Map<Integer, Integer> dijkstra(WeightedGraph graph, int start) {
        Map<Integer, Integer> distances = new HashMap<>();
        for (int vertex : graph.getVertices()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[] { start, 0 });

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentVertex = current[0];
            int currentDistance = current[1];

            if (currentDistance > distances.get(currentVertex)) {
                continue;
            }

            for (WeightedGraph.Edge edge : graph.getAdjVertices(currentVertex)) {
                int neighbor = edge.destination;
                int newDist = currentDistance + edge.weight;

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    pq.add(new int[] { neighbor, newDist });
                }
            }
        }
        return distances;
    }

    public static int[][] floydWarshall(WeightedGraph graph) {
        int size = graph.getVertices().size();
        int[][] dist = new int[size][size];

        for (int i = 0; i < size; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int vertex : graph.getVertices()) {
            for (WeightedGraph.Edge edge : graph.getAdjVertices(vertex)) {
                dist[vertex][edge.destination] = edge.weight;
            }
        }

        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        return dist;
    }

    public static List<int[]> kruskalMST(WeightedGraph graph) {
        Map<Integer, List<WeightedGraph.Edge>> adjVerticesMap = graph.getAdjVerticesMap();
        List<int[]> edges = new ArrayList<>();

        for (int vertex : graph.getVertices()) {
            for (WeightedGraph.Edge edge : adjVerticesMap.get(vertex)) {
                edges.add(new int[] { vertex, edge.destination, edge.weight });
            }
        }
        edges.sort(Comparator.comparingInt(a -> a[2]));

        List<int[]> mst = new ArrayList<>();
        int[] parent = new int[graph.getVertices().size()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int vertex1 = edge[0];
            int vertex2 = edge[1];

            int root1 = find(parent, vertex1);
            int root2 = find(parent, vertex2);

            if (root1 != root2) {
                mst.add(edge);
                parent[root1] = root2;
            }
        }
        return mst;
    }

    private static int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }
}
