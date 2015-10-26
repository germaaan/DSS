package estados;

public class EstadoAcelerando implements Estado {

    private static EstadoAcelerando instancia = new EstadoAcelerando();
    private static final String TEXTO_TITULO = "ACELERANDO";
    private static final String TEXTO_BOTON_ON_OFF = "Apagar";
    private static final String COLOR_TITULO = "green";
    private static final String COLOR_BOTON_ON_OFF = "red";
    private static final String COLOR_BOTON_ACELERAR = "green";

    private EstadoAcelerando() {
    }

    public static EstadoAcelerando getInstancia() {
        return instancia;
    }

    @Override
    public String getTextoTitulo() {
        return EstadoAcelerando.TEXTO_TITULO;
    }

    @Override
    public String getTextoBotonOnOff() {
        return EstadoAcelerando.TEXTO_BOTON_ON_OFF;
    }

    @Override
    public String getColorTitulo() {
        return EstadoAcelerando.COLOR_TITULO;
    }

    @Override
    public String getColorBotonOnOff() {
        return EstadoAcelerando.COLOR_BOTON_ON_OFF;
    }

    @Override
    public String getColorBotonAcelerar() {
        return EstadoAcelerando.COLOR_BOTON_ACELERAR;
    }

    @Override
    public boolean procesarSenial(MaquinaEstados maquinaEstados, int senial) {
        if (senial == SIGNAL_ON_OFF) {
            maquinaEstados.cambiarEstado(EstadoApagado.getInstancia());
            return true;
        } else {
            return false;
        }
    }
}
