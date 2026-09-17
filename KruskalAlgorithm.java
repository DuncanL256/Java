import java.util.Arrays;
import java.util.Comparator;

public class KruskalAlgorithm {
    // Edge class to represent graph edges
    static class Edge {
        int src, dest, weight;
        
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    
    // Subset class for union-find operations
    static class Subset {
        int parent, rank;
        
        public Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }
    
    private int vertices;
    private Edge[] edges;
    private int edgeCount;
    
    public KruskalAlgorithm(int vertices, int maxEdges) {
        this.vertices = vertices;
        this.edges = new Edge[maxEdges];
        this.edgeCount = 0;
    }
    
    // Add an edge to the graph
    public void addEdge(int src, int dest, int weight) {
        edges[edgeCount++] = new Edge(src, dest, weight);
    }
    
    // Find the subset of an element
    private int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }
    
    // Union of the two selected subsets
    private void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
    
    // Find Minimum Spanning Tree using Kruskal's algorithm
    public Edge[] findMST() {
        Edge[] result = new Edge[vertices - 1];
        
        // Sort edges by weight
        Arrays.sort(edges, 0, edgeCount, new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.weight - e2.weight;
            }
        });
        
        // Create subset for each vertex
        Subset[] subsets = new Subset[vertices];
        for (int i = 0; i < vertices; i++) {
            subsets[i] = new Subset(i, 0);
        }
        
        int resultIndex = 0;
        int edgeIndex = 0;
        
        // Build Minimum Spanning Tree with vertices minus 1 edge
        while (resultIndex < vertices - 1 && edgeIndex < edgeCount) {
            Edge nextEdge = edges[edgeIndex++];
            
            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);
            
            // Include edge if it doesn't form a cycle
            if (x != y) {
                result[resultIndex++] = nextEdge;
                union(subsets, x, y);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Test with a sample graph
        int vertices = 4;
        KruskalAlgorithm graph = new KruskalAlgorithm(vertices, 5);
        
        // Add edges: (src, dest, weight)
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);
        
        // Find Minimum Spanning Tree using Kruskal's algorithm
        Edge[] mst = graph.findMST();
        
        System.out.println("Edges in the Minimum Spanning Tree:");
        int totalWeight = 0;
        for (Edge edge : mst) {
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Total weight of MST: " + totalWeight);
    }
}
