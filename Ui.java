import java.util.Scanner; 


public class Ui {

    public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What product do you want?");
        while (scanner.hasNext()) {
            String productName = scanner.nextLine();
            int productID = scanner.nextInt();
            float cost = scanner.nextFloat();
        }
    }
}
