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

    @ManagedProperty(value = "#{colorTitulo}")
    private String colorTitulo;

    @ManagedProperty(value = "#{colorBotonOnOff}")
    private String colorBotonOnOff;

    @ManagedProperty(value = "#{colorBotonAcelerar}")
    private String colorBotonAcelerar;

    public String getTextoTitulo() {
        return "APAGADO";
    }

    public String getTextoBotonOnOff() {
        return "Encender";
    }

    public String getColorTitulo() {
        return "red";
    }

    public String getColorBotonOnOff() {
        return "red";
    }

    public String getColorBotonAcelerar() {
        return "black";
    }

    public void setTextoTitulo(String textoTitulo) {
        this.textoTitulo = textoTitulo;
    }

    public void setTextoBotonOnOff(String textoBotonOnOff) {
        this.textoBotonOnOff = textoBotonOnOff;
    }

    public void setColorTitulo(String colorTitulo) {
        this.colorTitulo = colorTitulo;
    }

    public void setColorBotonOnOff(String colorBotonOnOff) {
        this.colorBotonOnOff = colorBotonOnOff;
    }

    public void setColorBotonAcelerar(String colorBotonAcelerar) {
        this.colorBotonAcelerar = colorBotonAcelerar;
    }
}
