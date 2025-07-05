package Services;
import classes.*;

import java.util.List;
import java.util.Map;


public  class ShippingService {
   public  double totalWeight = 0;
    public  double Totalfees = 0;
    public  void shippingProducts(Map<Product,Integer> productQuantity) {

        System.out.println("** Shipment notice **");
        for (Map.Entry<Product, Integer> entry : productQuantity.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            if (product instanceof shippableProduct) {
                totalWeight+=((shippableProduct) product).getWeight()*quantity;
                System.out.println( "x"+quantity+"               "+product.getName()+ "          "+((shippableProduct) product).getWeight()*quantity+"\n");
                Totalfees+=((shippableProduct) product).getFees();
            }
            else if (product instanceof expirableAndShippableProduct) {
                totalWeight+=((expirableAndShippableProduct) product).getWeight()*quantity;
                System.out.println("x"+quantity+"               "+product.getName()+ "          "+((expirableAndShippableProduct) product).getWeight()*quantity+"\n");
                Totalfees+=((expirableAndShippableProduct) product).getFees();
            }
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}
