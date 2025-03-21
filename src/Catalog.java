import java.util.Date;
import java.util.HashMap;

public class Catalog {
    private final Date fechaDeVigencia;
    private final HashMap<Product, Integer> listaDePrecios;

    public Catalog(Date unaFechaDeVigencia, HashMap<Product, Integer> unaListaDePrecios) {
        if (unaListaDePrecios.isEmpty()) {
            throw new IllegalArgumentException("Lista de precios vacia");
        }
        this.fechaDeVigencia = unaFechaDeVigencia;
        this.listaDePrecios = unaListaDePrecios;
    }
}
