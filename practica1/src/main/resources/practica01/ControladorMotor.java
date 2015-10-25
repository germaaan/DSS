package practica01;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "controladorMotor", eager = true)
@SessionScoped
public class ControladorMotor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{textoTitulo}")
    private String textoTitulo;

    public String getTextoTitulo() {
        return "PRUEBA";
    }

    public void setTextoTitulo(String textoTitulo) {
        this.textoTitulo = "PRUEBA";
    }
}
