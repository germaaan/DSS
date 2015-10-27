package estados;

public class EstadoEncendido implements Estado {

    private static EstadoEncendido instancia = new EstadoEncendido();

    private EstadoEncendido() {
    }

    public static EstadoEncendido getInstancia() {
        return instancia;
    }

    @Override
    public String getTextoTitulo() {
        return Estado.TITULO_ENCENDIDO;
    }

    @Override
    public String getTextoBotonOnOff() {
        return Estado.TEXTO_APAGAR;
    }

    @Override
    public String getColorTitulo() {
        return Estado.COLOR_AZUL;
    }

    @Override
    public String getColorBotonOnOff() {
        return Estado.COLOR_ROJO;
    }

    @Override
    public String getColorBotonAcelerar() {
        return Estado.COLOR_AZUL;
    }

    @Override
    public boolean procesarSenial(MaquinaEstados maquinaEstados, int senial) {
        if (senial == Estado.SIGNAL_ON_OFF) {
            maquinaEstados.cambiarEstado(EstadoApagado.getInstancia());
            return true;
        } if (senial == Estado.SIGNAL_ACELERAR) {
            maquinaEstados.cambiarEstado(EstadoAcelerando.getInstancia());
            return true;
        } else {
            return false;
        }
    }
}
