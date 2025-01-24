import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/*
    -- HOW TO MANIPULATE CSV FILES WITH THIS CLASS --

    1. Open a CSV with "readCsv([filepath]);"

    2. Perform all add/remove operations

    3. Write changes back to the CSV with "writeCsv([filepath])"
        - NOTE: You can create a new CSV by changing the path that you pass into "writeCsv"
            EX. writeCsv("./data2.csv"); will create a new CSV called "data2" with the contents of the product list
 */ 

public class Backend {
    // -- Product class --
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

    // Main csv filepath
    public static final String CSV_PATH = "./data.csv";

    // Get list 
    public static ArrayList<Product> getList() { return products; }

    // Adds a product to the master product list
    public static void addProduct(String name, float cost, int id) {
        readCsv(CSV_PATH);

        Product prod = new Product(name, cost, id);
        products.add(prod);

        writeCsv(CSV_PATH);
    }

    // Remove product from list by properties
    public static void removeProduct(String name, float cost, int id) {
        readCsv(CSV_PATH);

        Product rProduct = null;
        for (Product p : products) {
            if (!p.getName().equals(name)) {
                continue;
            }
            if (p.getCost() != cost) {
                continue;
            }
            if (p.getId() != id) {
                continue;
            }
            
            rProduct = p;
            break;
        }

        if (rProduct != null && productExists(rProduct)) {
            products.remove(rProduct);
        }
        else {
            System.out.println("Error: trying to remove product that doesn't exist");
        }

        writeCsv(CSV_PATH);
    }

    public static boolean productExists(Product prod) {
        readCsv(CSV_PATH);
        return products.contains(prod);
    }


    // File processing

    // Flush database and add all values from csv
    private static void readCsv(String filePath) {
        products.clear();
        
        try {
            BufferedReader f = new BufferedReader(new FileReader(filePath));
            String line;

            // First line is garbage- skip it
            f.readLine();

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

    public static void printProducts() {
        readCsv(CSV_PATH);

        if (products.isEmpty()) {
            System.out.println("product list is empty.");
        } else {
            System.out.println("Current Produect list is: ");
            for (Product p: products) {
                System.out.println(p.getCost() + ", " + p.getCost() + "," + p.getName());

            }
        }
    }

    // Write the contents of the product list into a csv
    private static void writeCsv(String path) {
        if (products.isEmpty())
            System.out.println("No products to write");

        try {
            FileWriter f = new FileWriter(path);

            // Write header
            f.write("Product_Name,Cost,Product_ID\n");

            // Write each product's name, cost, and id to a line in the csv
            for (Product p : products) {
                if (p == null)
                    continue;
                
                String line = p.name + "," + p.cost + "," + p.id + "\n";
                f.write(line);
            }
            f.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Read products in from original data csv
        readCsv("data.csv");

        // Add new product
        addProduct("thing", 20, 999);
        // removeProduct("thing", 20, 999);

        // Write everything to a completely new file "data2.csv"
        writeCsv("data2.csv");
    }
}
