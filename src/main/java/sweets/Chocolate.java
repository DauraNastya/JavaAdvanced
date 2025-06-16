package sweets;

public class Chocolate extends Sweetness {
    private String type;

    public Chocolate(String name, Double weight, Double price, String type) {
        super(name, weight, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "[Chocolate " + super.toString() + " type: " + type + "]";
    }
}