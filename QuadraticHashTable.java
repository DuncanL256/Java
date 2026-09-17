// A hash table implementation using quadratic probing for collision resolution
// This should cover the extra credit section
public class QuadraticHashTable<K, V> {
    // Class to represent a key-value pair
    private class Entry<K, V> {
        private K key;
        private V value;
        private boolean isDeleted;  // For lazy deletion
        
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.isDeleted = false;
        }
    }
    
    private static final double LOAD_FACTOR_THRESHOLD = 0.7;  // Resize when load factor exceeds this
    private Entry<K, V>[] table;    // Array to store entries
    private int size;               // Number of entries in the table
    private int capacity;           // Current table capacity
    private final int c1 = 1;       // Quadratic coefficient
    private final int c2 = 0;       // Linear coefficient
    
    // Constructor with initial capacity
    @SuppressWarnings("unchecked")
    public QuadraticHashTable(int initialCapacity) {
        // Find next prime number >= initialCapacity
        this.capacity = nextPrime(initialCapacity);
        this.table = (Entry<K, V>[]) new Entry[capacity];
        this.size = 0;
    }
    
    // Default constructor
    public QuadraticHashTable() {
        this(11);  // Default initial capacity
    }
    
    // Hash function
    private int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }
    
    // Add (put) a key-value pair to the hash table
    public void add(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        
        // Check if resize is needed
        if ((double) size / capacity >= LOAD_FACTOR_THRESHOLD) {
            resize();
        }
        
        int index = findSlot(key);
        
        if (table[index] == null || table[index].isDeleted) {
            // New entry or replacing a deleted entry
            table[index] = new Entry<>(key, value);
            size++;
        } else if (table[index].key.equals(key)) {
            // Update existing key
            table[index].value = value;
        }
    }
    
    // Search (get) a value by key
    public V search(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        
        int index = findSlot(key);
        
        if (table[index] != null && !table[index].isDeleted && table[index].key.equals(key)) {
            return table[index].value;
        }
        
        return null;  // Key not found
    }
    
    // Delete (remove) a key-value pair
    public boolean delete(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        
        int index = findSlot(key);
        
        if (table[index] != null && !table[index].isDeleted && table[index].key.equals(key)) {
            table[index].isDeleted = true;  // Lazy deletion
            size--;
            return true;
        }
        
        return false;  // Key not found
    }
    
    // Find the slot for a key using quadratic probing
    private int findSlot(K key) {
        int h = hash(key);
        int i = 0;
        int index = h;
        
        // Probe until we find an empty slot, a deleted slot, or the key itself
        while (table[index] != null && 
               !table[index].isDeleted && 
               !table[index].key.equals(key)) {
            i++;
            // Quadratic probing formula: h(i) = (h(k) + c1*i^2 + c2*i) mod m
            index = (h + c1 * i * i + c2 * i) % capacity;
        }
        
        return index;
    }
    
    // Print all elements in the hash table
    public void print() {
        System.out.println("Hash Table Contents (Quadratic Probing):");
        System.out.println("Size: " + size + ", Capacity: " + capacity);
        
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null && !table[i].isDeleted) {
                System.out.println("Index " + i + ": Key = " + table[i].key + ", Value = " + table[i].value);
            }
        }
        System.out.println();
    }
    
    // Detect clusters and return the size of the largest cluster
    public int detectClusters() {
        int largestCluster = 0;
        int currentCluster = 0;
        
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null && !table[i].isDeleted) {
                currentCluster++;
                largestCluster = Math.max(largestCluster, currentCluster);
            } else {
                currentCluster = 0;
            }
        }
        
        // Check for wrap-around cluster
        int wrapCluster = 0;
        int endCluster = 0;
        int startCluster = 0;
        
        // Count elements at the end
        for (int i = capacity - 1; i >= 0 && table[i] != null && !table[i].isDeleted; i--) {
            endCluster++;
        }
        
        // Count elements at the beginning
        for (int i = 0; i < capacity && table[i] != null && !table[i].isDeleted; i++) {
            startCluster++;
        }
        
        wrapCluster = endCluster + startCluster;
        
        return Math.max(largestCluster, wrapCluster);
    }
    
    // Resize and rehash the table
    @SuppressWarnings("unchecked")
    private void resize() {
        int oldCapacity = capacity;
        Entry<K, V>[] oldTable = table;
        
        // Find a new prime size greater than double the old size
        capacity = nextPrime(2 * oldCapacity);
        table = (Entry<K, V>[]) new Entry[capacity];
        size = 0;
        
        // Rehash all existing entries
        for (int i = 0; i < oldCapacity; i++) {
            if (oldTable[i] != null && !oldTable[i].isDeleted) {
                add(oldTable[i].key, oldTable[i].value);
            }
        }
    }
    
    // Helper method to find the next prime number >= n
    private int nextPrime(int n) {
        if (n <= 1) {
            return 2;
        }
        
        int prime = n;
        boolean found = false;
        
        while (!found) {
            prime++;
            if (isPrime(prime)) {
                found = true;
            }
        }
        
        return prime;
    }
    
    // Helper method to check if a number is prime
    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    // Getter methods
    public int size() {
        return size;
    }
    
    public int capacity() {
        return capacity;
    }
}
