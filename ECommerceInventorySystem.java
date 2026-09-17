// Tester class for the e-commerce inventory system
public class ECommerceInventorySystem {
    public static void main(String[] args) { //testing area
        testDoubleHashing();
        testQuadraticProbing();
        testHybridApproach();
    }
    
    private static void testDoubleHashing() {
        System.out.println("======= TESTING DOUBLE HASHING =======");
        DoubleHashTable<String, Product> inventory = new DoubleHashTable<>(11);
        
        // Add some products for us to test with
        inventory.add("LP001", new Product("LP001", "Laptop", 999.99, 50));
        inventory.add("SP002", new Product("SP002", "Smartphone", 699.99, 100));
        inventory.add("HD003", new Product("HD003", "Headphones", 149.99, 200));
        inventory.add("MN004", new Product("MN004", "Monitor", 299.99, 75));
        inventory.add("KB005", new Product("KB005", "Keyboard", 89.99, 150));
        
        // Print the current state
        inventory.print();
        
        // Search for products
        System.out.println("Searching for product with ID HD003: " + inventory.search("HD003"));
        System.out.println("Searching for product with ID XX999: " + inventory.search("XX999"));
        
        // Delete a product
        System.out.println("Deleting product with ID SP002: " + inventory.delete("SP002"));
        
        // Print after deletion
        inventory.print();
        
        // Detect clusters
        System.out.println("Largest cluster size: " + inventory.detectClusters());
        
        // Add more products to trigger resize
        System.out.println("Adding more products to trigger resize...");
        for (int i = 6; i <= 20; i++) {
            String id = String.format("PR%03d", i);
            inventory.add(id, new Product(id, "Product " + i, 10.0 * i, 20 + i));
        }
        
        // Print after resize
        inventory.print();
        
        // Detect clusters after resize
        System.out.println("Largest cluster size after resize: " + inventory.detectClusters());
    }
    
    private static void testQuadraticProbing() { // tests the extra credit quadratic probing
        System.out.println("\n======= TESTING QUADRATIC PROBING =======");
        QuadraticHashTable<String, Product> inventory = new QuadraticHashTable<>(11);
        
        // Add some products
        inventory.add("LP001", new Product("LP001", "Laptop", 999.99, 50));
        inventory.add("SP002", new Product("SP002", "Smartphone", 699.99, 100));
        inventory.add("HD003", new Product("HD003", "Headphones", 149.99, 200));
        inventory.add("MN004", new Product("MN004", "Monitor", 299.99, 75));
        inventory.add("KB005", new Product("KB005", "Keyboard", 89.99, 150));
        
        // Print the current state
        inventory.print();
        
        // Search for products
        System.out.println("Searching for product with ID HD003: " + inventory.search("HD003"));
        System.out.println("Searching for product with ID XX999: " + inventory.search("XX999"));
        
        // Delete a product
        System.out.println("Deleting product with ID SP002: " + inventory.delete("SP002"));
        
        // Print after deletion
        inventory.print();
        
        // Detect clusters
        System.out.println("Largest cluster size: " + inventory.detectClusters());
        
        // Add more products to trigger resize
        System.out.println("Adding more products to trigger resize...");
        for (int i = 6; i <= 20; i++) {
            String id = String.format("PR%03d", i);
            inventory.add(id, new Product(id, "Product " + i, 10.0 * i, 20 + i));
        }
        
        // Print after resize
        inventory.print();
        
        // Detect clusters after resize
        System.out.println("Largest cluster size after resize: " + inventory.detectClusters());
    }
    
    private static void testHybridApproach() {
        System.out.println("\n======= TESTING HYBRID APPROACH =======");
        HybridHashTable<String, Product> inventory = new HybridHashTable<>(11);
        
        // Add some products
        inventory.add("LP001", new Product("LP001", "Laptop", 999.99, 50));
        inventory.add("SP002", new Product("SP002", "Smartphone", 699.99, 100));
        inventory.add("HD003", new Product("HD003", "Headphones", 149.99, 200));
        inventory.add("MN004", new Product("MN004", "Monitor", 299.99, 75));
        inventory.add("KB005", new Product("KB005", "Keyboard", 89.99, 150));
        
        // Print the current state
        inventory.print();
        
        // Search for products
        System.out.println("Searching for product with ID HD003: " + inventory.search("HD003"));
        System.out.println("Searching for product with ID XX999: " + inventory.search("XX999"));
        
        // Delete a product
        System.out.println("Deleting product with ID SP002: " + inventory.delete("SP002"));
        
        // Print after deletion
        inventory.print();
        
        // Detect clusters
        System.out.println("Largest cluster size: " + inventory.detectClusters());
        
        // Add products that might cause clustering
        System.out.println("Adding products that might cause clustering...");
        // These products are designed to hash to the same bucket
        for (int i = 0; i < 5; i++) {
            String id = "CL" + i;
            inventory.add(id, new Product(id, "Clustered Product " + i, 99.99, 10));
        }
        
        // Print after potential technique switch
        inventory.print();
        
        // Detect clusters after potential switch
        System.out.println("Largest cluster size after additions: " + inventory.detectClusters());
    }
    
    // Product class for the inventory system
    private static class Product {
        private String id;
        private String name;
        private double price;
        private int quantity;
        
        public Product(String id, String name, double price, int quantity) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }
        
        @Override
        public String toString() {
            return String.format("Product[id=%s, name=%s, price=%.2f, quantity=%d]", 
                    id, name, price, quantity);
        }
    }
}

// There is surely some dead code in these files but im reluctant to delete anything because code might stop working
