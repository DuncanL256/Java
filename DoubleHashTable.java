// A hash table implementation using double hashing for resolution of collisions
public class DoubleHashTable<K, V> {
    // this class to represent a key-value pair
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
    
    private static final double LOAD_FACTOR_THRESHOLD = 0.7;  // Resize when load factor exceeds this specefied threshold
    private Entry<K, V>[] table;    // Array to store entries
    private int size;               // Number of entries in the table
    private int capacity;           // Current table capacity
    
    // Constructor with initial capacity
    @SuppressWarnings("unchecked")
    public DoubleHashTable(int initialCapacity) {
        // Find next prime number >= initialCapacity
        this.capacity = nextPrime(initialCapacity);
        this.table = (Entry<K, V>[]) new Entry[capacity];
        this.size = 0;
    }
    
    // Default constructor
    public DoubleHashTable() {
        this(11);  // Default initial capacity
    }
    
    // First hash function (reffered to as primary hash)
    private int hash1(K key) {
        return Math.abs(key.hashCode() % capacity);
    }
    
    // Second hash function (step size for probing)
    // Important note: h2 must never return 0
    private int hash2(K key) {
        // Using a smaller prime number than capacity for second hash
        return 1 + Math.abs(key.hashCode() % (capacity - 1));
    }
    
    // Add/put a key-value pair to the hash table
    public void add(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        
        // Check if a resize is needed
        if ((double) size / capacity >= LOAD_FACTOR_THRESHOLD) {
            resize();
        }
        
        int index = findSlot(key);
        
        if (table[index] == null || table[index].isDeleted) {
            // makes a new entry or replacing a deleted entry
            table[index] = new Entry<>(key, value);
            size++;
        } else if (table[index].key.equals(key)) {
            // Updates the existing key
            table[index].value = value;
        }
    }
    
    // Search/get a value by key
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
    
    // Delete/remove a key value pair
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
        
        return false;  // if key is not found
    }
    
    // Find the slot for a key (for insertion or lookup)
    private int findSlot(K key) {
        int h1 = hash1(key);
        int h2 = hash2(key);
        int i = 0;
        int index = h1;
        
        // Probe until we find an empty slot, a deleted slot, or the key itself
        while (table[index] != null && 
               !table[index].isDeleted && 
               !table[index].key.equals(key)) {
            i++;
            index = (h1 + i * h2) % capacity;  // Double hashing formula
        }
        
        return index;
    }
    
    // Print out all the elements in the hash table
    public void print() {
        System.out.println("Hash Table Contents:");
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
    
    // Helper method to find the next prime number greater than or equal to n
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
