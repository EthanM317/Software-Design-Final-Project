import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Backend {
    public class Product {
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
    }
    
    private ArrayList<Product> products;    

    // Get list 
    private ArrayList<Product> getList() { return products; }

    // Adds a product to the master product list
    public void addProduct(String name, float cost, int id) {
        Product prod = new Product(name, cost, id);
        products.add(prod);
    }

    // Remove a product from the list by name
    // public void removeProduct(String name) {
        
    // }

    // Remove product from list by reference
    public void removeProduct(Product product) {
        if (productExists(product)) {
            products.remove(product);
        }
        else {
            System.out.println("Error: trying to remove product that doesn't exist");
        }
    }

    public boolean productExists(Product prod) {
        return products.contains(prod);
    }


    // File processing

    // Flush database and add all values from csv
    public void readProducts(String filePath) {
        products.clear();
        
        try {
            BufferedReader f = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = f.readLine()) != null) {
                String[] values = line.split(",");
                
                addProduct(values[0], Float.parseFloat(values[1]), Integer.parseInt(values[2]));
            }
            f.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

    }
}
