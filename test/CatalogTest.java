import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CatalogTest {

    @Test()
    public void CatalogoSiempreComienzaConFechaDeVigenciaYListaDePrecios() throws
            IllegalArgumentException {
        HashMap<Product, Integer> listaDePrecios =  new HashMap<>();

        assertThrows(IllegalArgumentException.class, () -> new Catalog(new Date(), listaDePrecios));
    }

    @Test()
    public void CatalogoConocePrecioDeProducto() {
        HashMap<Product, Integer> listaDePrecios =  new HashMap<>();
        Product aProduct = new Product("arroz");
        listaDePrecios.put(aProduct, 10);

        Catalog aCatalog = new Catalog(new Date(), listaDePrecios);

        assertEquals(10, aCatalog.getPriceOf(aProduct));
    }

    @Test()
    public void SiCatalogoNoConoceProductoDebeLanzarUnError() throws IllegalArgumentException {
        HashMap<Product, Integer> listaDePrecios =  new HashMap<>();
        Product aProduct = new Product("arroz");
        listaDePrecios.put(aProduct, 10);
        Catalog aCatalog = new Catalog(new Date(), listaDePrecios);

        Product aNonExistProduct = new Product("FIDEOS");

        assertThrows(IllegalArgumentException.class, () -> aCatalog.getPriceOf(aNonExistProduct));
    }
}