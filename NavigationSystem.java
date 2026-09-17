import java.util.Scanner;

public class NavigationSystem {
    private static final int INF = Integer.MAX_VALUE;
    private static final int VERTICES = 10;
    private int[][] graph;
    private String[] locations;
    
    public NavigationSystem() {
        graph = new int[VERTICES][VERTICES];
        locations = new String[VERTICES];
        
        // Initialize graph with INF (no connection)
        for (int i = 0; i < VERTICES; i++) {
            for (int j = 0; j < VERTICES; j++) {
                if (i == j) {
                    graph[i][j] = 0;  // Distance to its self is 0
                } else {
                    graph[i][j] = INF;  // No direct connection
                }
            }
        }
        
        // Initializes the locations
        locations[0] = "Downtown";
        locations[1] = "Airport";
        locations[2] = "University";
        locations[3] = "Shopping Mall";
        locations[4] = "Hospital";
        locations[5] = "Park";
        locations[6] = "Beach";
        locations[7] = "Museum";
        locations[8] = "Stadium";
        locations[9] = "Library";
        
        // Add roads (edges) with default (unchanged) distances
        addRoad(0, 1, 10);  // Downtown to Airport
        addRoad(0, 2, 5);   // Downtown to University
        addRoad(0, 3, 8);   // Downtown to Shopping Mall
        addRoad(1, 4, 12);  // Airport to Hospital
        addRoad(1, 5, 15);  // Airport to Park
        addRoad(2, 5, 6);   // University to Park
        addRoad(2, 6, 14);  // University to Beach
        addRoad(3, 6, 7);   // Shopping Mall to Beach
        addRoad(3, 7, 9);   // Shopping Mall to Museum
        addRoad(4, 7, 8);   // Hospital to Museum
        addRoad(4, 8, 11);  // Hospital to Stadium
        addRoad(5, 9, 9);   // Park to Library
        addRoad(6, 8, 10);  // Beach to Stadium
        addRoad(7, 9, 6);   // Museum to Library
        addRoad(8, 9, 7);   // Stadium to Library
        
        // Add more roads connect more locations of the graph
        addRoad(0, 4, 7);   // Downtown to Hospital
        addRoad(1, 3, 9);   // Airport to Shopping Mall
        addRoad(2, 7, 12);  // University to Museum
        addRoad(5, 8, 8);   // Park to Stadium
    }
    
    // Add a road (edge) to the graph
    private void addRoad(int src, int dest, int weight) {
        graph[src][dest] = weight;
        graph[dest][src] = weight;  // Undirected graph to keep things simple
    }
    
    // Update a road's weight
    public void updateRoadWeight(int src, int dest, int newWeight) {
        graph[src][dest] = newWeight;
        graph[dest][src] = newWeight;  // Undirected graph for simplicity
    }
    
    // Find the vertex with the minimum distance value
    private int minDistance(int[] dist, boolean[] visited) {
        int min = INF;
        int minIndex = -1;
        
        for (int v = 0; v < VERTICES; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        
        return minIndex;
    }
    
    // Find shortest path using Dijkstra's shortest path algorithm
    public int[] findShortestPath(int src, int dest) {
        int[] dist = new int[VERTICES];  // Distance from the source to each vertex
        int[] prev = new int[VERTICES];  // Previous vertex in the shortest path
        boolean[] visited = new boolean[VERTICES];  // Visited vertices
        
        // Initialize distances as INFINITE and the visited as false
        for (int i = 0; i < VERTICES; i++) {
            dist[i] = INF;
            visited[i] = false;
            prev[i] = -1;
        }
        
        // Distance from source to itself is marked as 0
        dist[src] = 0;
        
        // Find shortest path for all vertices
        for (int count = 0; count < VERTICES - 1; count++) {
            // Pick the vertex with minimum distance
            int u = minDistance(dist, visited);
            
            if (u == -1) break;  // No more reachable vertices
            
            // Mark the picked vertex as processed
            visited[u] = true;
            
            // Update distances of adjacent vertices
            for (int v = 0; v < VERTICES; v++) {
                // Update dist[v] only under certain conditions (below):
                // 1. v is not visited yet
                // 2. there is an edge from u to v
                // 3. total weight of path from src to v through u is smaller than current value of dist[v]
                if (!visited[v] && graph[u][v] != INF && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    prev[v] = u;
                }
            }
        }
        
        // Reconstruct the path
        if (dist[dest] == INF) {
            return new int[0];  // No path exists
        }
        
        // Count path length
        int pathLength = 1;
        int current = dest;
        while (current != src) {
            pathLength++;
            current = prev[current];
            if (current == -1) {
                return new int[0];  // No path exists
            }
        }
        
        // Create a path array
        int[] path = new int[pathLength];
        current = dest;
        for (int i = pathLength - 1; i >= 0; i--) {
            path[i] = current;
            current = prev[current];
        }
        
        return path;
    }
    
    // Find the location index by name
    public int findLocationIndex(String name) {
        for (int i = 0; i < locations.length; i++) {
            if (locations[i].equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;  // Location not found return if something fails
    }
    
    // Display any available locations
    public void showLocations() {
        System.out.println("Available locations:");
        for (int i = 0; i < locations.length; i++) {
            System.out.println((i + 1) + ". " + locations[i]);
        }
    }
    
    // Display the shortest path between two locations
    public void showShortestPath(int src, int dest) {
        int[] path = findShortestPath(src, dest);
        
        if (path.length == 0) {
            System.out.println("No path exists between " + locations[src] + " and " + locations[dest]);
            return;
        }
        
        System.out.print("Shortest path from " + locations[src] + " to " + locations[dest] + ": ");
        int totalDistance = 0;
        
        for (int i = 0; i < path.length; i++) {
            System.out.print(locations[path[i]]);
            
            if (i < path.length - 1) {
                System.out.print(" -> ");
                totalDistance += graph[path[i]][path[i + 1]];
            }
        }
        
        System.out.println(" with total distance: " + totalDistance);
    }
    
    // Main menu located below
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        
        while (choice != 4) {
            System.out.println("\n===== Navigation System Menu =====");
            System.out.println("1. Show existing locations");
            System.out.println("2. Find shortest path between two locations");
            System.out.println("3. Update road weight (traffic condition)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine();  // Clear the newline character
            
            switch (choice) {
                case 1:
                    showLocations();
                    break;
                    
                case 2:
                    System.out.println("Enter source location name: ");
                    String srcName = scanner.nextLine();
                    int src = findLocationIndex(srcName);
                    
                    System.out.println("Enter destination location name: ");
                    String destName = scanner.nextLine();
                    int dest = findLocationIndex(destName);
                    
                    if (src == -1 || dest == -1) {
                        System.out.println("Invalid location name!");
                    } else {
                        showShortestPath(src, dest);
                    }
                    break;
                    
                case 3:
                    System.out.println("Enter first location name: ");
                    String loc1Name = scanner.nextLine();
                    int loc1 = findLocationIndex(loc1Name);
                    
                    System.out.println("Enter second location name: ");
                    String loc2Name = scanner.nextLine();
                    int loc2 = findLocationIndex(loc2Name);
                    
                    if (loc1 == -1 || loc2 == -1) {
                        System.out.println("Invalid location name!");
                    } else if (graph[loc1][loc2] == INF) {
                        System.out.println("No direct road exists between these locations!");
                    } else {
                        System.out.println("Current road weight: " + graph[loc1][loc2]);
                        System.out.println("Enter new road weight: ");
                        int newWeight = scanner.nextInt();
                        scanner.nextLine();  // Clear the newline character
                        
                        updateRoadWeight(loc1, loc2, newWeight);
                        System.out.println("Road weight updated successfully!");
                    }
                    break;
                    
                case 4:
                    System.out.println("Exiting Navigation System. Goodbye!");
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        
        scanner.close();
    }
    
    public static void main(String[] args) {
        NavigationSystem nav = new NavigationSystem();
        nav.showMenu();
    }
}
