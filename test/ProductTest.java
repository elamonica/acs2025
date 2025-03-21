import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {


    @Test()
    public void DosProductosSonIgualesSiySoloSiSeLlamanIgual() {
        Product unProducto = new Product("Uno");
        Product otroProducto = new Product("Uno");

        assertEquals(unProducto, otroProducto);
        assertEquals(unProducto.hashCode(), otroProducto.hashCode());
    }

    @Test()
    public void DosProductosSonIgualesSiySoloSiSeLlamanIgualCaseInsensitive() {
        Product unProducto = new Product("UNO");
        Product otroProducto = new Product("uno");

        assertEquals(unProducto, otroProducto);
        assertEquals(unProducto.hashCode(), otroProducto.hashCode());
    }

    @Test()
    public void DosProductosSonDistintosSiySoloSiSeLlamanDistintoCaseInsensitive() {
        Product unProducto = new Product("UNO");
        Product otroProducto = new Product("dos");

        assertNotEquals(unProducto, otroProducto);
        assertNotEquals(unProducto.hashCode(), otroProducto.hashCode());
    }
}