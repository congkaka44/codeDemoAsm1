public class sorting {
    import java.util.*;

    public class Dijkstra {
        static class Node implements Comparable<Node> {
            int vertex, weight;
            Node(int vertex, int weight) { this.vertex = vertex; this.weight = weight; }
            public int compareTo(Node other) { return Integer.compare(this.weight, other.weight); }
        }

        public static void dijkstra(int[][] graph, int source) {
            int V = graph.length, dist[] = new int[V];
            boolean visited[] = new boolean[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[source] = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(source, 0));

            while (!pq.isEmpty()) {
                int u = pq.poll().vertex;
                if (visited[u]) continue;
                visited[u] = true;

                for (int v = 0; v < V; v++) {
                    if (graph[u][v] > 0 && !visited[v]) {
                        int newDist = dist[u] + graph[u][v];
                        if (newDist < dist[v]) {
                            dist[v] = newDist;
                            pq.add(new Node(v, newDist));
                        }
                    }
                }
            }
            System.out.println("Shortest distances: " + Arrays.toString(dist));
        }

        public static void main(String[] args) {
            int[][] graph = {
                    {0, 7, 9, 0, 0, 14},
                    {7, 0, 10, 15, 0, 0},
                    {9, 10, 0, 11, 0, 2},
                    {0, 15, 11, 0, 6, 0},
                    {0, 0, 0, 6, 0, 9},
                    {14, 0, 2, 0, 9, 0}
            };
            dijkstra(graph, 0);
        }
    }

}
import java.util.*;

public class Prim {
    public static void prim(int[][] graph) {
        int V = graph.length;
        boolean[] inMST = new boolean[V];
        int[] key = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0; // Start from the first vertex
        PriorityQueue<Node> pq = new PriorityQueue<>(V, Comparator.comparingInt(node -> node.key));
        pq.add(new Node(0, key[0]));

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;
            inMST[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    pq.add(new Node(v, key[v]));
                }
            }
        }

        // Print the MST weights
        System.out.println("Minimum spanning tree weights: " + Arrays.toString(key));
    }

    static class Node {
        int vertex;
        int key;

        Node(int vertex, int key) {
            this.vertex = vertex;
            this.key = key;
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 2, 0, 6, 0, 0},
                {2, 0, 3, 8, 5, 0},
                {0, 3, 0, 0, 7, 0},
                {6, 8, 0, 0, 9, 0},
                {0, 5, 7, 9, 0, 4},
                {0, 0, 0, 0, 4, 0}
        };
        prim(graph);
    }
}

