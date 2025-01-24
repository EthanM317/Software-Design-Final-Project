import java.util.Scanner; 


public class Ui {

    public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        String addMore = "Y";
        while(scanner.hasNext() && !addMore.equals("N")){
            System.out.println("Enter product name: "); 
            String productName = scanner.nextLine();
            System.out.println("Enter ID: "); 
            int productID = scanner.nextInt(); 
            System.out.println("Enter cost: "); 
            float cost = scanner.nextFloat();

            Backend.addProduct(productName, cost, productID);

            System.out.println("Do you want to add another product? Enter Y or N ");
            addMore = scanner.nextLine(); 
        }
    }

    public void removeProduct() {
        Scanner scanner = new Scanner(Scanner(System.in));
        String remove = "Y"
        while(scanner.hasNext() && !remove.equals("N")){
            System.out.println("Enter product name: "); 
            String productName = scanner.nextLine();
            System.out.println("Enter ID: "); 
            int productID = scanner.nextInt(); 
            System.out.println("Enter cost: "); 
            float cost = scanner.nextFloat();

            Backend.removeProduct(productName, cost, productID);

            System.out.println("Do you want to remove another product? Enter Y or N ");
            remove = scanner.nextLine(); 
        }
    }
}

