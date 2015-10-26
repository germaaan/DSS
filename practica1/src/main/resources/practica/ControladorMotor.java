package practica;

import estados.*;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "controladorMotor", eager = true)
@RequestScoped
public class ControladorMotor implements Serializable {

    private static final long serialVersionUID = 1L;
    private MaquinaEstados estadoMotor = new MaquinaEstados(EstadoApagado.getInstancia());

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

    public void actualizarBotonOnOff(ActionEvent e) {
        this.estadoMotor.enviarSenial(Estado.SIGNAL_ON_OFF);
    }

    public String getTextoTitulo() {
        return this.estadoMotor.getEstado().getTextoTitulo();
    }

    public String getTextoBotonOnOff() {
        return this.estadoMotor.getEstado().getTextoBotonOnOff();
    }

    public String getColorTitulo() {
        return this.estadoMotor.getEstado().getColorTitulo();
    }

    public String getColorBotonOnOff() {
        return this.estadoMotor.getEstado().getColorBotonOnOff();
    }

    public String getColorBotonAcelerar() {
        return this.estadoMotor.getEstado().getColorBotonAcelerar();
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
