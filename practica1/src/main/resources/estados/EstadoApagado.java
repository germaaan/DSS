package estados;

public class EstadoApagado implements Estado {

    private static EstadoApagado instancia = new EstadoApagado();
    private static final String TEXTO_TITULO = "APAGADO";
    private static final String TEXTO_BOTON_ON_OFF = "Encender";
    private static final String COLOR_TITULO = "red";
    private static final String COLOR_BOTON_ON_OFF = "blue";
    private static final String COLOR_BOTON_ACELERAR = "black";

    private EstadoApagado() {
    }

    public static EstadoApagado getInstancia() {
        return instancia;
    }

    @Override
    public String getTextoTitulo() {
        return EstadoApagado.TEXTO_TITULO;
    }

    @Override
    public String getTextoBotonOnOff() {
        return EstadoApagado.TEXTO_BOTON_ON_OFF;
    }

    @Override
    public String getColorTitulo() {
        return EstadoApagado.COLOR_TITULO;
    }

    @Override
    public String getColorBotonOnOff() {
        return EstadoApagado.COLOR_BOTON_ON_OFF;
    }

    @Override
    public String getColorBotonAcelerar() {
        return EstadoApagado.COLOR_BOTON_ACELERAR;
    }

    /*
     @Override
     public boolean procesarSenial(MaquinaEstados maquinaEstados, int senial) {
     if (senial == Estado.SIGNAL_ON_OFF) {
     maquinaEstados.cambiarEstado(EstadoEncendido.getInstancia());
     return true;
     } else {
     return false;
     }
     }
     */
}
