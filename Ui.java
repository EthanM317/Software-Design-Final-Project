import java.lang.classfile.instruction.ThrowInstruction;
import java.util.Scanner; 


public class Ui {
    private static Scanner scanner = new Scanner(System.in);
    //Ui main
    private static void menu(){
        System.out.println("----------");
        System.out.println("Please choose one of the following options:");
        System.out.println("Enter 1 for viewing list of products");
        System.out.println("Enter 2 for adding a product");
        System.out.println("Enter 3 for editing a product");
        System.out.println("Enter 4 for deleting a product");
        int choice = scanner.nextInt();
        //options
        switch (choice) {
            case 1:
                
                break;
            case 2:
                addProduct();
                break;
            case 3:
                
                break;
            case 4:
                removeProduct();
                break;
            default:
                System.out.println("Entered an invalid option");
        }

    }


    private static void printProducts(){
        Backend.printProducts();
    }
    
    private static void editProducts(){

    }

    private static void addProduct() {
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

    private static void removeProduct() {
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
    
}

