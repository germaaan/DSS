package practica;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "controladorMotor", eager = true)
@RequestScoped
public class ControladorMotor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{textoTitulo}")
    private String textoTitulo;

    @ManagedProperty(value = "#{textoBotonOnOff}")
    private String textoBotonOnOff;

    public String getTextoTitulo() {
        return "APAGADO";
    }

    public void setTextoTitulo(String textoTitulo) {
        this.textoTitulo = textoTitulo;
    }

    public String getTextoBotonOnOff() {
        return "Encender";
    }

    public void setTextoBotonOnOff(String textoBotonOnOff) {
        this.textoBotonOnOff = textoBotonOnOff;
    }
}
