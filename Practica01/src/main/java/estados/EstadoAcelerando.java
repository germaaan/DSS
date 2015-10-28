package estados;

public class EstadoAcelerando implements Estado {

    private static EstadoAcelerando instancia = new EstadoAcelerando();

    private EstadoAcelerando() {
    }

    public static EstadoAcelerando getInstancia() {
        return instancia;
    }

    @Override
    public String getTextoTitulo() {
        return EstadoAcelerando.TITULO_ACELERANDO;
    }

    @Override
    public String getTextoBotonOnOff() {
        return Estado.TEXTO_APAGAR;
    }

    @Override
    public String getColorTitulo() {
        return Estado.COLOR_VERDE;
    }

    @Override
    public String getColorBotonOnOff() {
        return Estado.COLOR_ROJO;
    }

    @Override
    public String getColorBotonAcelerar() {
        return Estado.COLOR_VERDE;
    }

    @Override
    public boolean procesarSenial(MaquinaEstados maquinaEstados, int senial) {
        if (senial == SIGNAL_ON_OFF) {
            maquinaEstados.setEstado(EstadoApagado.getInstancia());
            return true;
        } else {
            return false;
        }
    }
}
