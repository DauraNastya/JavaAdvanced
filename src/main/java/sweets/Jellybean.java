package sweets;

public class Jellybean extends Sweetness {
    private String elasticity;

    public Jellybean() {
        super();
    }

    public Jellybean(String name, Double weight, Double price, String elasticity) {
        super(name, weight, price);
        this.elasticity = elasticity;
    }

    public String getElasticity() {
        return elasticity;
    }

    public void setElasticity(String elasticity) {
        this.elasticity = elasticity;
    }

    @Override
    public String toString() {
        return "[Jellybean " + super.toString() + " elasticity: " + elasticity + "]";
    }
}