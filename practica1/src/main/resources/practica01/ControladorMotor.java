package practica01;
import estados.*;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name="controladormotor",eager=true)
@SessionScoped
public class ControladorMotor implements Serializable{
    private static final long serialVersionUID = 1L;
    private MaquinaEstados estadoMotor = new MaquinaEstados(EstadoApagado.getInstancia());
    
    // mirar import correcto
    public void actualizarBotonOnOff(ActionEvent e){
        estadoMotor.enviarSenial(Estado.SIGNAL_ON_OFF);
    }
    
    public void actualizarBotonAcelerar(ActionEvent e){
        estadoMotor.enviarSenial(Estado.SIGNAL_ACELERAR);
    }
    
    public String getTextoTitulo(){
        return estadoMotor.getEstado().getTextoTitulo();
    }
}
