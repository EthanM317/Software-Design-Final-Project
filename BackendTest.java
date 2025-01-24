public class BackendTest {
    public static void main(String[] args) {

        Backend.addProduct("Apple", 1.99f, 100983);
        Backend.addProduct("Banana", 0.79f, 100984);
        Backend.addProduct("Orange", 1.49f, 100985);
        Backend.addProduct("Milk", 3.99f, 1009856);

        Backend.printProducts();
    }
}
