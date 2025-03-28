public class MerchantProcessorSinSaldo implements IMerchantProcessor {
    @Override
    public Boolean validate(CreditCard aCreditCard, int totalPrice) {
        return false;
    }

    @Override
    public Boolean cobrate(CreditCard aCreditCard, int totalPrice) {
        return null;
    }
}
