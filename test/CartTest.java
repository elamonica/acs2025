import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest {

    @Test()
    public void CreateCartShouldBeEmpty_001() {
        Cart aCart = new Cart();

        assertTrue(aCart.isEmpty());
    }

    @Test()
    public void AlAgregarUnProductoAlCarritoElCarritoDejaDeEstarVacio_002() {
        Cart aCart = new Cart();
        Product aProduct = createProductArroz();

        aCart.add(aProduct);

        assertFalse(aCart.isEmpty());
    }

    @Test()
    public void AlAgregarUnProductoAlCarritoElCarritoContieneElProducto_003() {
        Cart aCart = new Cart();
        Product aProduct = createProductArroz();
        aCart.add(aProduct);

        assertTrue(aCart.contains(aProduct));
    }

    @Test()
    public void QuitarUnProductoAgregadoAlCarritoDejaAlCarritoVacio_004() {
        Cart aCart = new Cart();
        Product aProduct = createProductArroz();
        aCart.add(aProduct);
        assertTrue(aCart.contains(aProduct));

        aCart.remove(aProduct);

        assertTrue(aCart.isEmpty());
    }

    @Test()
    public void QuitarUnProductoQueNoExisteEnElCarritoDebeNoHacerseNada_005() {
        Cart aCart = new Cart();
        Product aProduct = createProductArroz();

        aCart.remove(aProduct);

        assertTrue(aCart.isEmpty());
    }

    private static Product createProductArroz() {
        Product aProduct = new Product("arroz");
        return aProduct;
    }
}
