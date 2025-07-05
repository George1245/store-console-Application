import classes.*;

import java.util.Scanner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();
        System.out.println("Enter your Balance: ");
        double balance = scanner.nextDouble();
        Customer customer = new Customer(balance,cart);
        List<Product> products = new ArrayList<Product>();
        Product cheeseProduct = new expirableAndShippableProduct("cheese",100,5,500,   LocalDate.of(2027, 12, 5),50);
        Product biscuitsProduct = new expirableAndShippableProduct("biscuits",100,50,500, LocalDate.of(2026, 12, 5),50);
        Product TV = new shippableProduct("TV",20000,3,5000,100);

        products.add(cheeseProduct);
        products.add(biscuitsProduct);
        products.add(TV);


        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + "- " + products.get(i).getName());
        }
        while (true) {
            System.out.println("choose from our products and press 0 to finish and check out: ");
            int userIndex = scanner.nextInt();
            if(userIndex==0) {
                break;
            }
            System.out.print("enter the quantity of the item you want to add to the cart: ");
            int quantity = scanner.nextInt();
            int realIndex = userIndex - 1;
            if (realIndex >= 0 && realIndex < products.size()) {
                Product selectedProduct = products.get(realIndex);
                cart.addProduct(selectedProduct,quantity);
            }
        }
        customer.checkOut();

    }
}