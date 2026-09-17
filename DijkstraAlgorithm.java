public class DijkstraAlgorithm {
    private static final int INF = Integer.MAX_VALUE;
    
    private int vertices;
    private int[][] graph;  // Adjacency matrix
    
    public DijkstraAlgorithm(int vertices) {
        this.vertices = vertices;
        this.graph = new int[vertices][vertices];
        
        // Initialize graph with INF (no connection)
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (i == j) {
                    graph[i][j] = 0;  // Distance to self is 0
                } else {
                    graph[i][j] = INF;  // No direct connection
                }
            }
        }
    }
    
    // Add an edge to the graph
    public void addEdge(int src, int dest, int weight) {
        graph[src][dest] = weight;
    }
    
    // Find the vertex with minimum distance value
    private int minDistance(int[] dist, boolean[] visited) {
        int min = INF;
        int minIndex = -1;
        
        for (int v = 0; v < vertices; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        
        return minIndex;
    }
    
    // Dijkstra's algorithm to find shortest paths from source
    public int[] findShortestPaths(int src) {
        int[] dist = new int[vertices];  // Distance from source to each vertex
        int[] prev = new int[vertices];  // Previous vertex in the shortest path
        boolean[] visited = new boolean[vertices];  // Visited vertices
        
        // Initialize distances as INFINITE and visited as false
        for (int i = 0; i < vertices; i++) {
            dist[i] = INF;
            visited[i] = false;
            prev[i] = -1;
        }
        
        // Distance from source to itself is 0
        dist[src] = 0;
        
        // Find shortest path for all vertices
        for (int count = 0; count < vertices - 1; count++) {
            // Pick the vertex with minimum distance
            int u = minDistance(dist, visited);
            
            // Mark the picked vertex as processed
            visited[u] = true;
            
            // Update distances of adjacent vertices
            for (int v = 0; v < vertices; v++) {
                // Update dist[v] only if one of the following:
                // 1. v is not visited yet
                // 2. there is an edge from u to v
                // 3. total weight of path from src to v through u is smaller than current value of dist[v]
                if (!visited[v] && graph[u][v] != INF && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    prev[v] = u;
                }
            }
        }
        
        return dist;
    }
    
    // Get the shortest path from source to destination
    public int[] getShortestPath(int src, int dest) {
        int[] dist = new int[vertices];  // Distance from source to each vertex
        int[] prev = new int[vertices];  // Previous vertex in the shortest path
        boolean[] visited = new boolean[vertices];  // Visited vertices
        
        // Initialize distances as INFINITE and visited as false
        for (int i = 0; i < vertices; i++) {
            dist[i] = INF;
            visited[i] = false;
            prev[i] = -1;
        }
        
        // Distance from source to itself is 0
        dist[src] = 0;
        
        // Find shortest path for all vertices
        for (int count = 0; count < vertices - 1; count++) {
            // Pick the vertex with minimum distance
            int u = minDistance(dist, visited);
            
            // Mark the picked vertex as processed
            visited[u] = true;
            
            // Update distances of adjacent vertices
            for (int v = 0; v < vertices; v++) {
                // Update dist[v] only if one of the following:
                // 1. v is not visited yet
                // 2. there is an edge from u to v
                // 3. total weight of path from src to v through u is smaller than current value of dist[v]
                if (!visited[v] && graph[u][v] != INF && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    prev[v] = u;
                }
            }
        }
        
        // Reconstruct path
        if (dist[dest] == INF) {
            return new int[0];  // if no path exists
        }
        
        // Count path length
        int pathLength = 1;
        int current = dest;
        while (current != src) {
            pathLength++;
            current = prev[current];
        }
        
        // Create path array
        int[] path = new int[pathLength];
        current = dest;
        for (int i = pathLength - 1; i >= 0; i--) {
            path[i] = current;
            current = prev[current];
        }
        
        return path;
    }
    
    public static void main(String[] args) {
        // Test with a sample graph
        int vertices = 6;
        DijkstraAlgorithm graph = new DijkstraAlgorithm(vertices);
        
        // Add edges: (src, dest, weight)
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 3, 10);
        graph.addEdge(2, 3, 3);
        graph.addEdge(2, 4, 2);
        graph.addEdge(3, 4, 4);
        graph.addEdge(3, 5, 11);
        graph.addEdge(4, 5, 5);
        
        // Find shortest paths from source vertex 0
        int[] distances = graph.findShortestPaths(0);
        
        System.out.println("Shortest distances from source (vertex 0):");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + ": " + distances[i]);
        }
        
        // Get and print shortest path from 0 to 5
        int[] path = graph.getShortestPath(0, 5);
        if (path.length > 0) {
            System.out.print("Shortest path from 0 to 5: ");
            for (int i = 0; i < path.length; i++) {
                System.out.print(path[i]);
                if (i < path.length - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println(" (Total distance: " + distances[5] + ")");
        } else {
            System.out.println("No path exists from 0 to 5");
        }
    }
}