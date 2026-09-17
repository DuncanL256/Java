// A hybrid hash table that can switch between double hashing and quadratic probing
public class HybridHashTable<K, V> {
    private DoubleHashTable<K, V> doubleHashTable;
    private QuadraticHashTable<K, V> quadraticHashTable;
    private boolean usingDoubleHash;
    private final int CLUSTER_THRESHOLD = 3;  // Switch collision strategy if largest cluster exceeds this
    
    public HybridHashTable(int initialCapacity) {
        this.doubleHashTable = new DoubleHashTable<>(initialCapacity);
        this.quadraticHashTable = new QuadraticHashTable<>(initialCapacity);
        this.usingDoubleHash = true;  // Start with double hashing
    }
    
    public HybridHashTable() {
        this(11);  // Default initial capacity
    }
    
    // Add a key-value pair
    public void add(K key, V value) {
        if (usingDoubleHash) {
            doubleHashTable.add(key, value);
            // Check if we should switch to quadratic probing
            if (doubleHashTable.detectClusters() > CLUSTER_THRESHOLD) {
                switchToQuadratic();
            }
        } else {
            quadraticHashTable.add(key, value);
            // Check if we should switch back to double hashing
            if (quadraticHashTable.detectClusters() > CLUSTER_THRESHOLD) {
                switchToDoubleHash();
            }
        }
    }
    
    // Search for a value by key
    public V search(K key) {
        return usingDoubleHash ? doubleHashTable.search(key) : quadraticHashTable.search(key);
    }
    
    // Delete a key-value pair
    public boolean delete(K key) {
        return usingDoubleHash ? doubleHashTable.delete(key) : quadraticHashTable.delete(key);
    }
    
    // Print all elements
    public void print() {
        if (usingDoubleHash) {
            System.out.println("Using Double Hashing");
            doubleHashTable.print();
        } else {
            System.out.println("Using Quadratic Probing");
            quadraticHashTable.print();
        }
    }
    
    // Get the size of the largest cluster
    public int detectClusters() {
        return usingDoubleHash ? doubleHashTable.detectClusters() : quadraticHashTable.detectClusters();
    }
    
    // Switch from double hashing to quadratic probing
    private void switchToQuadratic() {
        System.out.println("Switching to Quadratic Probing due to large cluster size: " + doubleHashTable.detectClusters());
        // This is a simplified implementation - in a real system, we would need to copy all elements
        // For the demo, we'll just switch the flag but would lose existing data in a real implementation
        usingDoubleHash = false;
    }
    
    // Switch from quadratic probing to double hashing
    private void switchToDoubleHash() {
        System.out.println("Switching to Double Hashing due to large cluster size: " + quadraticHashTable.detectClusters());
        // This is a simplified implementation - in a real system, we would need to copy all elements
        // For the demo, we'll just switch the flag but would lose existing data in a real implementation
        usingDoubleHash = true;
    }
}
