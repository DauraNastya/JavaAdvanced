package sweets;

public class Candy extends Sweetness {
    private String size;

    public Candy(String name, Double weight, Double price, String size) {
        super(name, weight, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "[Candy " + super.toString() + " size: " + size + "]";
    }
}
