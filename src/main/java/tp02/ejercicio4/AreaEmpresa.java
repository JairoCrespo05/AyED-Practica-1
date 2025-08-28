package tp02.ejercicio4;

public class AreaEmpresa {

    private String identificador;
    private int tardanzaDeTransmision;


    public AreaEmpresa(String identificador, int tardanzaDeTransmision) {
        this.identificador = identificador;
        this.tardanzaDeTransmision = tardanzaDeTransmision;
    }

    public String MiIndentificadorEs(){ return this.identificador;}

    public int MiTardanzaDeTransmision(){ return  this.tardanzaDeTransmision;}

}
