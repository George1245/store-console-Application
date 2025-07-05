package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart
{
   public List<Product>  products = new ArrayList<Product>();
   private Map<Product,Integer> productQuantity = new HashMap<Product,Integer>();

    public void setProductQuantity(Map<Product, Integer> productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Map<Product, Integer> getProductQuantity() {
        return productQuantity;
    }

    public void addProduct(Product product, int quantity)
    {
        if((product instanceof expirableProduct)&& ((expirableProduct) product).isExpired() )
        {
            throw new IllegalStateException("this product is expired!!");
        }
        else if((product instanceof expirableAndShippableProduct)&& ((expirableAndShippableProduct) product).isExpired() )
        {
            throw new IllegalStateException("this product is expired!!");
        }
        else if(product.getQuantity()==0) {
            throw new IllegalStateException("this product is out of stock!");
        }
        else if(quantity>=product.getQuantity()) {
            throw new IllegalStateException("Quantity exceeds the maximum quantity!");
        }
        else if(quantity<=product.getQuantity()) {
            productQuantity.put(product, quantity);
            products.add(product);
            product.setQuantity(product.getQuantity()-quantity);
        }


    }
}
