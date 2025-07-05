package classes;

import java.time.LocalDate;

public class expirableAndShippableProduct extends Product implements expirableProductInterface, shippableProductInterface {
    private double weight;
    private double Fees;
    private LocalDate expiryDate;
    public expirableAndShippableProduct(String name, double price, int quantity,double weight, LocalDate expiryDate, double Fees) {
        super(name, price, quantity);
        this.weight =  weight;
        this.expiryDate = expiryDate;
        this.Fees = Fees;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }
    public void setFees(double fees) {
        this.Fees = fees;
    }
    public double getFees() {
        return Fees;

    }

    public boolean isExpired() {
        return getExpiryDate().isBefore(LocalDate.now());
    }


}
