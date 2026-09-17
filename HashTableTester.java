public class HashTableTester {
    public static void main(String[] args) {
        // Test Double Hashing
        testDoubleHashing();
        
        // Test Quadratic Probing
        testQuadraticProbing();
        
        // Test Hybrid Approach
        testHybridApproach();
    }
    
    private static void testDoubleHashing() {
        System.out.println("======= TESTING DOUBLE HASHING =======");
        DoubleHashTable<Integer, String> inventory = new DoubleHashTable<>(11);
        
        // Add some products
        inventory.add(1001, "Laptop");
        inventory.add(1002, "Smartphone");
        inventory.add(1003, "Headphones");
        inventory.add(1004, "Monitor");
        inventory.add(1005, "Keyboard");
        
        // Print the current state
        inventory.print();
        
        // Search for products
        System.out.println("Searching for product with ID 1003: " + inventory.search(1003));
        System.out.println("Searching for product with ID 9999: " + inventory.search(9999));
        
        // Delete a product
        System.out.println("Deleting product with ID 1002: " + inventory.delete(1002));
        
        // Print after deletion
        inventory.print();
        
        // Detect clusters
        System.out.println("Largest cluster size: " + inventory.detectClusters());
        
        // Add more products to trigger resize
        System.out.println("Adding more products to trigger resize...");
        for (int i = 1006; i <= 1020; i++) {
            inventory.add(i, "Product " + i);
        }
        
        // Print after resize
        inventory.print();
        
        // Detect clusters after resize
        System.out.println("Largest cluster size after resize: " + inventory.detectClusters());
    }
    
    private static void testQuadraticProbing() {
        System.out.println("======= TESTING QUADRATIC PROBING =======");
        QuadraticHashTable<Integer, String> inventory = new QuadraticHashTable<>(11);
        
        // Add some products
        inventory.add(1001, "Laptop");
        inventory.add(1002, "Smartphone");
        inventory.add(1003, "Headphones");
        inventory.add(1004, "Monitor");
        inventory.add(1005, "Keyboard");
        
        // Print the current state
        inventory.print();
        
        // Search for products
        System.out.println("Searching for product with ID 1003: " + inventory.search(1003));
        System.out.println("Searching for product with ID 9999: " + inventory.search(9999));
        
        // Delete a product
        System.out.println("Deleting product with ID 1002: " + inventory.delete(1002));
        
        // Print after deletion
        inventory.print();
        
        // Detect clusters
        System.out.println("Largest cluster size: " + inventory.detectClusters());
        
        // Add more products to trigger resize
        System.out.println("Adding more products to trigger resize...");
        for (int i = 1006; i <= 1020; i++) {
            inventory.add(i, "Product " + i);
        }
        
        // Print after resize
        inventory.print();
        
        // Detect clusters after resize
        System.out.println("Largest cluster size after resize: " + inventory.detectClusters());
    }
    
    private static void testHybridApproach() {
        System.out.println("======= TESTING HYBRID APPROACH =======");
        HybridHashTable<Integer, String> inventory = new HybridHashTable<>(11);
        
        // Add some products
        inventory.add(1001, "Laptop");
        inventory.add(1002, "Smartphone");
        inventory.add(1003, "Headphones");
        inventory.add(1004, "Monitor");
        inventory.add(1005, "Keyboard");
        
        // Print the current state
        inventory.print();
        
        // Search for products
        System.out.println("Searching for product with ID 1003: " + inventory.search(1003));
        System.out.println("Searching for product with ID 9999: " + inventory.search(9999));
        
        // Delete a product
        System.out.println("Deleting product with ID 1002: " + inventory.delete(1002));
        
        // Print after deletion
        inventory.print();
        
        // Detect clusters
        System.out.println("Largest cluster size: " + inventory.detectClusters());
        
        // Add more products that might trigger a switch between techniques
        System.out.println("Adding products that might cause clustering...");
        for (int i = 0; i <= 50; i += 11) {  // Adding products that hash to the same slot
            inventory.add(i, "Clustered Product " + i);
        }
        
        // Print after potential technique switch
        inventory.print();
        
        // Detect clusters after potential switch
        System.out.println("Largest cluster size after additions: " + inventory.detectClusters());
    }
}
