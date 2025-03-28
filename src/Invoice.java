public class Invoice {
    private final int totalAmount;

    public Invoice(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int totalAmount() {
        return totalAmount;
    }
}
