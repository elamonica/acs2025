import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
    - Cobrarlo
        - Recibir el metodo de pago
        - X - Calcular el precio del carrito
            - Aplicar descuentos
        - Entrega factura despues del pago
    - Podria responder el precio de un producto
    - Anular una compra
 */
class CashierTest {
    @Test()
    public void CashierConoceElPrecioDelCarrito(){
        HashMap<Product, Integer> listaDePrecios =  new HashMap<>();
        Product aProduct = new Product("arroz");
        listaDePrecios.put(aProduct, 10);
        Catalog aCatalog = new Catalog(new Date(), listaDePrecios);

        Cart aCart = new Cart();
        aCart.add(aProduct);

        Cashier aCashier = new Cashier();

        assertEquals(10, aCashier.totalPriceOf(aCart, aCatalog));
    }

    @Test()
    public void CashierCobraElCarritoYEmiteFactura(){
        HashMap<Product, Integer> listaDePrecios =  new HashMap<>();
        Product aProduct = new Product("arroz");
        listaDePrecios.put(aProduct, 10);
        Catalog aCatalog = new Catalog(new Date(), listaDePrecios);

        Cart aCart = new Cart();
        aCart.add(aProduct);

        Cashier aCashier = new Cashier();
        CreditCard aCreditCard = new CreditCard();

        Invoice anInvoice = aCashier.cobrar(aCart, aCatalog, aCreditCard, new MerchantProcessor());
        assertEquals(10, anInvoice.totalAmount());
    }

    @Test()
    public void CashierCobraElCarritoConTarjetaSinSaldoDebeEmitirException() throws IllegalArgumentException {
        HashMap<Product, Integer> listaDePrecios =  new HashMap<>();
        Product aProduct = new Product("arroz");
        listaDePrecios.put(aProduct, 10);
        Catalog aCatalog = new Catalog(new Date(), listaDePrecios);

        Cart aCart = new Cart();
        aCart.add(aProduct);

        Cashier aCashier = new Cashier();
        CreditCard aCreditCard = new CreditCard();
        MerchantProcessorSinSaldo aMerchantProcessorSinSaldo = new MerchantProcessorSinSaldo();
        assertThrows(IllegalArgumentException.class, () -> aCashier.cobrar(aCart, aCatalog, aCreditCard, aMerchantProcessorSinSaldo));
    }
}