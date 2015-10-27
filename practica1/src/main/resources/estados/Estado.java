package estados;

public interface Estado {

    public static final int SIGNAL_ON_OFF = 2;
    public static final int SIGNAL_ACELERAR = 3;
    public static final String TITULO_APAGADO = "APAGADO";
    public static final String TITULO_ENCENDIDO = "ENCENDIDO";
    public static final String TITULO_ACELERANDO = "ACELERANDO";
    public static final String TEXTO_ENCENDER = "Encender";
    public static final String TEXTO_APAGAR = "Apagar";
    public static final String COLOR_ROJO = "red";
    public static final String COLOR_VERDE = "green";
    public static final String COLOR_AZUL = "blue";
    public static final String COLOR_NEGRO = "black";

    public String getTextoTitulo();

    public String getTextoBotonOnOff();

    public String getColorTitulo();

    public String getColorBotonOnOff();

    public String getColorBotonAcelerar();

    public boolean procesarSenial(MaquinaEstados maquinaEstados, int senial);
}
