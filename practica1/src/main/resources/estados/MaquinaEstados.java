package estados;

public class MaquinaEstados{
    private Estado estado;
    
    public MaquinaEstados(EStado nuevoEstado){
        estado = nuevoEstado;
    }
    
    public void CambiarEstado(Estado nuevoEstado){
        estado = nuevoEstado;
    }
    
    public Object getEstado() {
        return estado;
    }
    
}
