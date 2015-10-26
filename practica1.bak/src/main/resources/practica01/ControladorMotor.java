package practica01;

import estados.*;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "controladorMotor", eager = true)
@RequestScoped
public class ControladorMotor implements Serializable {

    private static final long serialVersionUID = 1L;
    private MaquinaEstados estadoMotor = new MaquinaEstados(EstadoApagado.getInstancia());

    @ManagedProperty(value = "#{textoTitulo}")
    private String textoTitulo;

    public String getTextoTitulo() {
        return estadoMotor.getEstado().getTextoTitulo();
        //return "PRUEBA";
    }

    public void setTextoTitulo(String textoTitulo) {
        this.textoTitulo = textoTitulo;
    }
}
