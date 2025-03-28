public interface IMerchantProcessor {
    Boolean validate(CreditCard aCreditCard, int totalPrice);

    Boolean cobrate(CreditCard aCreditCard, int totalPrice);
}
