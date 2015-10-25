package estados;

public class EstadoAcelerar extends AcelerarEstadoOn implements Estado{
    private static EstadoAcelerar instancia=new EstadoAcelerar();
    
    private EstadoAcelerar(){
    }
    
    public static EstadoAcelerar getInstancia(){
        return instancia;
    }
    
    public String getTextoTitulo(){
        return ACELERANDO;
    }
    
    public String getColorTitulo(){
        return COLOR_AZUL;
    }
    
    public boolean ProcesarSenial(MaquinaEstados maquinaEstados, int senial){
        if (senial==SIGNAL_ON_OFF){
            maquinaEstados.CambiarEstado(EstadoApagado.getInstancia());
            return true;
        }
        else return false;
    }
}
