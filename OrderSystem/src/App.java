import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;

import models.entities.Client;
import models.entities.Order;
import models.entities.OrderItem;
import models.entities.Product;
import models.enums.OrderStatus;

public class App {
    public static void main(String[] args) throws ParseException {
        // Simple Date Format
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

       // Scanner
       Scanner sc = new Scanner(System.in);

       // Locale
       Locale.setDefault(Locale.US);

       // Client Data
        System.out.println("Enter cliente data:");
        System.out.print("Name:");
        String name = sc.next();

        System.out.print("Email:");
        String email = sc.next();

        System.out.print("Birth date (DD/MM/YYYY):");
        Date birthDate = sdf.parse(sc.next());

        Client client = new Client(name, email, birthDate);

        // Order Data
        System.out.print("Status:");
        String status = sc.next().toUpperCase();

        System.out.println("How many items to this order?");
        int n = sc.nextInt();

        Order order = new Order(new Date(), OrderStatus.valueOf(status), client);

        // Items
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter #" + n + " item data:");

            System.out.print("Product name:");
            String pName = sc.next();

            System.out.println("Product price:");
            double pPrice = sc.nextDouble();

            Product product = new Product(pName, pPrice);

            System.out.println("Quantity:");
            int quantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(quantity, pPrice, product);
            
            order.addItem(orderItem);
        }

        System.out.println("ORDER SUMMARY:");
        System.out.println(order);

       sc.close();

    }
}
