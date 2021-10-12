package week03.hola;

public class Discount {
    private String policy = "FixPolicy";
    private String amount;

    public Discount() {

    }

    public Discount(String policy, String amount) {
        this.policy = policy;
        this.amount = amount;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "policy='" + policy + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }

    private void method1() {
        System.out.println("Discount method1");
    }
}

