package estados;

public class EstadoApagado implements Estado {

    private static EstadoApagado instancia = new EstadoApagado();

    private EstadoApagado() {
    }

    public static EstadoApagado getInstancia() {
        return instancia;
    }

    @Override
    public String getTextoTitulo() {
        return Estado.TITULO_APAGADO;
    }

    @Override
    public String getTextoBotonOnOff() {
        return Estado.TEXTO_ENCENDER;
    }

    @Override
    public String getColorTitulo() {
        return Estado.COLOR_ROJO;
    }

    @Override
    public String getColorBotonOnOff() {
        return Estado.COLOR_AZUL;
    }

    @Override
    public String getColorBotonAcelerar() {
        return Estado.COLOR_NEGRO;
    }

    @Override
    public boolean procesarSenial(MaquinaEstados maquinaEstados, int senial) {
        if (senial == Estado.SIGNAL_ON_OFF) {
            maquinaEstados.setEstado(EstadoEncendido.getInstancia());
            return true;
        } else {
            return false;
        }
    }

}
