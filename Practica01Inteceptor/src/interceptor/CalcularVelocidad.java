package interceptor;

public class CalcularVelocidad implements Filtro {

    private static final double INTERVALO = 5.0;

    @Override
    public double ejecutar(double objetivo) {
        double distancia = objetivo;
        double velocidad = distancia * 3600 / INTERVALO;

        return velocidad;
    }

}
