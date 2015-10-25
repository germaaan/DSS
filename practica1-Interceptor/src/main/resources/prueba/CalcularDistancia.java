package prueba;

public class CalcularDistancia implements Filtro {

    private static final double RADIO = 5.0;

    @Override
    public double ejecutar(double objetivo) {
        double revoluciones = objetivo;
        double revolAnt = revoluciones;
        double distancia = (revoluciones - revolAnt) * 2 * RADIO * 3.1415;
        return distancia;
    }

}
