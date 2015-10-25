package estados;

public interface Estado {

    public static final int SIGNAL_ON_OFF = 0;
    public static final int SIGNAL_ACELERAR = 1;

    public String getTextoTitulo();

    public String getTextoBotonOnOff();

    public String getColorTitulo();

    public String getColorBotonOnOff();
    
    public String getColorBotonAcelerar();

    public boolean procesarSenial(MaquinaEstados maquinaEstados, int senial);
}
