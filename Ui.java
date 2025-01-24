import java.util.ArrayList;
import java.util.Scanner; 


public class Ui {
    //Ui main
    public static void menu(){
        System.out.println("----------");
        System.out.println("Please choose one of the following options:");
        System.out.println("Enter 1 for viewing list of products");
        System.out.println("Enter 2 for adding a product");
        System.out.println("Enter 3 for editing a product");
        System.out.println("Enter 4 for deleting a product");
    }


    private static Scanner scanner = new Scanner(System.in);

    public static void addProduct() {
        //tracks if user wants to continue or not
        String keepGoing = "Y";

        //gets values of each product property
        while(keepGoing.equals("Y") || keepGoing.equals("y")){
            System.out.println("Enter product name: "); 
            String productName = scanner.nextLine();
            System.out.println("Enter ID: ");
            int productID = scanner.nextInt(); 
            System.out.println("Enter cost: "); 
            float cost = scanner.nextFloat();

            //adds product
            Backend.addProduct(productName, cost, productID);

            //asks if user wants to continue
            System.out.println("Do you want to add another product? Enter Y or N ");
            keepGoing = scanner.nextLine();
            //ensures user entered a valid value for keepGoing
            while(!keepGoing.equals("Y") && !keepGoing.equals("N") && !keepGoing.equals("y") && !keepGoing.equals("n")) {
                System.out.print("Please enter Y or N: ");
                keepGoing = scanner.nextLine();
            }
        }
    }

    public static void removeProduct() {
        //tracks if user wants to continue removing items
        String keepGoing = "Y";
        //gets each property of the object you want to remove
        while(keepGoing.equals("Y") || keepGoing.equals("y")){
            System.out.println("Enter product name: "); 
            String productName = scanner.nextLine();
            System.out.println("Enter ID: "); 
            int productID = scanner.nextInt(); 
            System.out.println("Enter cost: "); 
            float cost = scanner.nextFloat();

            //removes product
            Backend.removeProduct(productName, cost, productID);

            //asks user if they want to remove another product
            System.out.println("Do you want to remove another product? Enter Y or N ");
            keepGoing = scanner.nextLine(); 
            //ensures a valid value for keepGoing
            while(!keepGoing.equals("Y") && !keepGoing.equals("N") && !keepGoing.equals("y") && !keepGoing.equals("n")) {
                System.out.print("Please enter Y or N: ");
                keepGoing = scanner.nextLine();
            }
        }
    }

    public static void editProduct() {
        // Get list of products
        ArrayList<Backend.Product> pList = Backend.getList();

        // Print out list of products
        int i=0;
        int maxIndex;
        for (Backend.Product p : pList) {
            System.out.println(i + " - " + p.getName() + ", " + p.getCost() + ", " + p.getId());
            i++;
        }
        maxIndex = i;

        boolean loop = true;
        while (loop) {
            System.out.println("Enter the index of the product you want to edit");
            String input = scanner.nextLine();

            try {
                int index = Integer.parseInt(input);
                
                if (index >= maxIndex || index < 0) {
                    System.out.println("please enter a valid index");
                    continue;
                }

                String newName;
                float newCost;
                int newId;

                System.out.print("\nEnter a new name: ");
                newName = scanner.nextLine();
                System.out.print("\nEnter a new cost: ");
                newCost =  scanner.nextFloat();
                System.out.print("\nEnter a new Id: ");
                newId = scanner.nextInt();


                Backend.Product editProduct = pList.get(index);
                editProduct.setName(newName);
                editProduct.setCost(newCost);
                editProduct.setId(newId);
                Backend.writeCsv(Backend.CSV_PATH);
                break;
            }
            catch (Exception e) {
                System.out.println("Please enter an integer number");
                continue;
            }
        }
    }
}

