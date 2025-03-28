import java.util.concurrent.atomic.AtomicInteger;

public class Cashier {
    public int totalPriceOf(Cart aCart, Catalog aCatalog) {
        AtomicInteger totalPrice = new AtomicInteger();
        aCart.getProducts().forEach(product -> totalPrice.addAndGet(aCatalog.getPriceOf(product)));

        return totalPrice.get();
    }

    public Invoice cobrar(Cart aCart, Catalog aCatalog, CreditCard aCreditCard, IMerchantProcessor aMerchantProcessor) {
        int totalPrice = totalPriceOf(aCart, aCatalog);

        Boolean isOk = aMerchantProcessor.validate(aCreditCard, totalPrice);
        if (isOk) {
            Boolean isPaymentOk = aMerchantProcessor.cobrate(aCreditCard, totalPrice);
            if (isPaymentOk) {
                return new Invoice(totalPrice);
            }
        } else {
            throw new IllegalArgumentException("Invalid merchant card");
        }

        return null;
    }
}
