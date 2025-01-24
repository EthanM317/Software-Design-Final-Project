import java.util.Scanner; 


public class Ui {

    public static void addProduct() {
        //start scanner
        Scanner scanner = new Scanner(System.in);
        //tracks if user wants to continue or not
        String keepGoing = "";

        //gets values of each product property
        while(scanner.hasNext() && keepGoing.equals("Y")){
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
        //stats scanner
        Scanner scanner = new Scanner(System.in);
        //tracks if user wants to continue removing items
        String keepGoing = "";
        //gets each property of the object you want to remove
        while(scanner.hasNext() && keepGoing.equals("Y")){
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

