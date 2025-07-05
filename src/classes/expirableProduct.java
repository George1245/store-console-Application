package classes;

import java.time.LocalDate;

public class expirableProduct extends Product implements expirableProductInterface{
    private LocalDate expiryDate;


    public expirableProduct(String name, double price, int quantity,LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public boolean isExpired() {
        return getExpiryDate().isBefore(LocalDate.now());
    }
}
