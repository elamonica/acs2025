public class MerchantProcessor implements IMerchantProcessor {
    @Override
    public Boolean validate(CreditCard aCreditCard, int totalPrice) {
        return true;
    }

    @Override
    public Boolean cobrate(CreditCard aCreditCard, int totalPrice) {
        return true;
    }
}
