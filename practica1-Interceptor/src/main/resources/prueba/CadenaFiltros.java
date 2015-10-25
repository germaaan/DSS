package prueba;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CadenaFiltros {

    private List<Filtro> filtros;
    private Interfaz objetivo;

    public CadenaFiltros() {
        this.filtros = new ArrayList<Filtro>();
    }

    public void setFiltro(Filtro filtro) {
        this.filtros.add(filtro);
    }

    public void ejecutar(double peticion) throws IOException, URISyntaxException {
        Iterator<Filtro> itr = filtros.iterator();

        while (itr.hasNext()) {
            Filtro filtro = itr.next();
            System.out.print("Nueva velocidad (m/s) " + filtro.ejecutar(peticion));
        }

        this.objetivo.ejecutar(peticion);
    }

    public void setObjetivo(Interfaz objetivo) {
        this.objetivo = objetivo;
    }
}
