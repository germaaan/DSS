package estados;

public class MaquinaEstados {

    private Estado estado;

    public MaquinaEstados(Estado nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void enviarSenial(int SIGNAL) {
        this.estado.procesarSenial(this, SIGNAL);
    }
}
