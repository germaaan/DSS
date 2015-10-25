package prueba;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Interfaz {

    private String url = "http://localhost:8080/practica1/home.xhtml";

    public void ejecutar(double peticion) throws IOException, URISyntaxException {
        System.out.println("Llamada a la interfaz");

        if (Desktop.isDesktopSupported()) {
            // Windows
            Desktop.getDesktop().browse(new URI(url));
        } else {
            // Ubuntu
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("/usr/bin/firefox -new-window " + url);
        }
    }
}
