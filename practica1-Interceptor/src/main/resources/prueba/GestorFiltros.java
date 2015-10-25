package prueba;

import java.io.IOException;
import java.net.URISyntaxException;

public class GestorFiltros {

    private CadenaFiltros cadenaFiltros;

    public GestorFiltros(Interfaz objetivo) {
        this.cadenaFiltros = new CadenaFiltros();
        cadenaFiltros.setObjetivo(objetivo);
    }

    public void setFiltro(Filtro filtro) {
        this.cadenaFiltros.setFiltro(filtro);
    }

    public void peticionFiltro(double peticion) throws IOException, URISyntaxException {
        this.cadenaFiltros.ejecutar(peticion);
    }
}
