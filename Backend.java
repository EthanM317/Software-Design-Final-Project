import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Backend {
    // Product class
    public static class Product {
        // Product properties
        private String name;
        private float cost;
        private int id;
        
        public Product(String name, float cost, int id)
        {
            this.name = name;
            this.cost = cost;
            this.id = id;
        }

        public String getName() { return name; }
        public float getCost() { return cost; }
        public int getId() { return id; }
    }
    
    // Main list of products
    private static ArrayList<Product> products = new ArrayList<>();    

    // Get list 
    public static ArrayList<Product> getList() { return products; }

    // Adds a product to the master product list
    public static void addProduct(String name, float cost, int id) {
        Product prod = new Product(name, cost, id);
        products.add(prod);
    }

    // Remove a product from the list by name
    // public void removeProduct(String name) {
        
    // }

    // Remove product from list by reference
    public static void removeProduct(Product product) {
        if (productExists(product)) {
            products.remove(product);
        }
        else {
            System.out.println("Error: trying to remove product that doesn't exist");
        }
    }

    public static boolean productExists(Product prod) {
        return products.contains(prod);
    }


    // File processing

    // Flush database and add all values from csv
    public static void readProducts(String filePath) {
        products.clear();
        
        try {
            BufferedReader f = new BufferedReader(new FileReader(filePath));
            String line;

            // First line is garbage
            f.readLine();

            while ((line = f.readLine()) != null) {
                String[] values = line.split(",");

                // System.out.println(values[0]);
                // System.out.println(values[1]);
                // System.out.println(values[2]);
                
                addProduct(values[0], Float.parseFloat(values[1]), Integer.parseInt(values[2]));
            }
            f.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readProducts("data.csv");
    }


    public static void printProducts() {
        if (products.isEmpty()) {
            System.out.println("product list is empty.");
        } else {
            System.out.println("Current Produect list is: ");
            for (Product p: products) {
                System.out.println(p.getCost() + ", " + p.getCost() + "," + p.getName());

            }
        }
    }

}
