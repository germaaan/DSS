package estados;

public class EstadoEncendido implements Estado {

    private static EstadoEncendido instancia = new EstadoEncendido();
    private static final String TEXTO_TITULO = "ENCENDIDO";
    private static final String TEXTO_BOTON_ON_OFF = "Apagar";
    private static final String COLOR_TITULO = "blue";
    private static final String COLOR_BOTON_ON_OFF = "red";
    private static final String COLOR_BOTON_ACELERAR = "blue";

    private EstadoEncendido() {
    }

    public static EstadoEncendido getInstancia() {
        return instancia;
    }

    @Override
    public String getTextoTitulo() {
        return EstadoEncendido.TEXTO_TITULO;
    }

    @Override
    public String getTextoBotonOnOff() {
        return EstadoEncendido.TEXTO_BOTON_ON_OFF;
    }

    @Override
    public String getColorTitulo() {
        return EstadoEncendido.COLOR_TITULO;
    }

    @Override
    public String getColorBotonOnOff() {
        return EstadoEncendido.COLOR_BOTON_ON_OFF;
    }

    @Override
    public String getColorBotonAcelerar() {
        return EstadoEncendido.COLOR_BOTON_ACELERAR;
    }

    @Override
    public boolean procesarSenial(MaquinaEstados maquinaEstados, int senial) {
        boolean result = false;

        switch (senial) {
            case Estado.SIGNAL_ACELERAR:
                maquinaEstados.cambiarEstado(EstadoAcelerando.getInstancia());
                result = true;
                break;
            case Estado.SIGNAL_ON_OFF:
                maquinaEstados.cambiarEstado(EstadoApagado.getInstancia());
                result = true;
                break;
        }

        return result;
    }
}
