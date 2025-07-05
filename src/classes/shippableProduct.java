package classes;

public class shippableProduct extends Product implements shippableProductInterface{
    private double weight;
    private double Fees;
    public shippableProduct(String name, double price, int quantity,double weight,double Fees) {
        super(name, price, quantity);
        this.weight = weight;
        this.Fees = Fees;
    }


    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }
    public void setFees(double fees) {
        this.Fees=fees;
    }
    public double getFees() {
        return Fees;
    }


}
