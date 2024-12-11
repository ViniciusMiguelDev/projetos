import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

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

        // Cliente data
        System.out.println("Enter cliente data:");
        System.out.print("Name: ");
        String name = sc.next();

        System.out.print("Email: ");
        String email = sc.next();

        System.out.print("Birth date (DD/MM/YYYY): ");
        Date bithDate = sdf.parse(sc.next());

        Client client = new Client(name, email, bithDate);

        // Order data:
        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus orderStatus = OrderStatus.valueOf(sc.next().toUpperCase());

        System.out.print("How many items to this order?");
        int n = sc.nextInt();

        Order order = new Order(new Date(), orderStatus, client);

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            String pName = sc.next();

            System.out.print("Product price: ");
            double pPrice = sc.nextDouble();

            Product product = new Product(pName, pPrice);

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(quantity, pPrice, product);

            order.addItem(orderItem);
        }
        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.println(order);

        sc.close();

    }
}
