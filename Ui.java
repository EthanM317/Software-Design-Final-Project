import java.util.Scanner; 


public class Ui {

    public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What product do you want?"); 
        String addMore = "Y";
        while(scanner.hasNext() && !addMore.equals("N")){
            String productName = scanner.nextLine();
            int productID = scanner.nextInt(); 
            float cost = scanner.nextFloat();

            Backend.addProduct(productName, cost, productID);

            System.out.println("Do you want to add another product? Enter Y or N ");
            addMore = scanner.nextLine();


        } 
    }
}

