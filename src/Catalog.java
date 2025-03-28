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

    public int getPriceOf(Product aProduct) {
        if (!listaDePrecios.containsKey(aProduct)) {
            throw new IllegalArgumentException("El producto no existe " + aProduct);
        }
        return listaDePrecios.get(aProduct);
    }
}
