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

    }

    @Test()
    public void SiCatalogoNoConoceProducto....() {

    }
}