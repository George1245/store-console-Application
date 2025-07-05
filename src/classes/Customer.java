package classes;
import Services.*;

import java.util.Map;

public class Customer {
  private double Balance;
  public static double totalPrice=0;

    Cart cart = new Cart();
    ShippingService shippingService = new ShippingService();

  public double getBalance() {
        return Balance;
    }
    public void setBalance(double balance) {
        Balance = balance;
    }

    public Customer(double balance, Cart cart) {
        Balance = balance;
        this.cart = cart;
    }
 public void checkOut(){
     if(cart.products.isEmpty()){
         throw new IllegalStateException("There are no products in this cart.");
     }
     for (Map.Entry<Product, Integer> entry : cart.getProductQuantity().entrySet()) {
         Product product = entry.getKey();
         int quantity = entry.getValue();
         totalPrice+=(product.getPrice()*quantity);
     }
     if(totalPrice >getBalance()){
         throw new IllegalStateException("There is insufficient balance!!");
     }

     shippingService.shippingProducts(cart.getProductQuantity());

     System.out.println("** Checkout receipt ** ");
     for (Map.Entry<Product, Integer> entry : cart.getProductQuantity().entrySet()) {
         Product product = entry.getKey();
         int quantity = entry.getValue();
         System.out.println( "x"+quantity+"               "+product.getName()+"          "+product.getPrice()+"\n");
     }
     System.out.println("---------------------------------------------------");
     System.out.println("subtotal:    "+totalPrice+"\n");
     System.out.println("Shipping:    "+shippingService.Totalfees+"\n");
     System.out.println("Amount:    "+(shippingService.Totalfees+totalPrice)+"\n");
     }


 }

