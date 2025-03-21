import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public Cart(List<Product> products) {
        this.products = products;
    }

    public boolean isEmpty() {
        return this.products.isEmpty();
    }

    public void add(Product aProduct) {
        this.products.add(aProduct);
    }

    public boolean contains(Product aProduct) {
        return this.products.contains(aProduct);
    }

    public void remove(Product aProduct) {
        this.products.remove(aProduct);
    }
}
