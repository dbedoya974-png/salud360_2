package app.domain;
public class SignoVital {
    private int idSignoVital; private String fecha; private double temperatura; private String presionArterial;
    private int frecuenciaCardiaca; private int frecuenciaRespiratoria; private double peso; private double talla; private int idConsulta;
    public SignoVital(){} public SignoVital(int idSignoVital,String fecha,double temperatura,String presionArterial,int frecuenciaCardiaca,int frecuenciaRespiratoria,double peso,double talla,int idConsulta){
        this.idSignoVital=idSignoVital;this.fecha=fecha;this.temperatura=temperatura;this.presionArterial=presionArterial;this.frecuenciaCardiaca=frecuenciaCardiaca;this.frecuenciaRespiratoria=frecuenciaRespiratoria;this.peso=peso;this.talla=talla;this.idConsulta=idConsulta;
    }
    public int getIdSignoVital(){return idSignoVital;} public void setIdSignoVital(int v){idSignoVital=v;}
    public String getFecha(){return fecha;} public void setFecha(String v){fecha=v;}
    public double getTemperatura(){return temperatura;} public void setTemperatura(double v){temperatura=v;}
    public String getPresionArterial(){return presionArterial;} public void setPresionArterial(String v){presionArterial=v;}
    public int getFrecuenciaCardiaca(){return frecuenciaCardiaca;} public void setFrecuenciaCardiaca(int v){frecuenciaCardiaca=v;}
    public int getFrecuenciaRespiratoria(){return frecuenciaRespiratoria;} public void setFrecuenciaRespiratoria(int v){frecuenciaRespiratoria=v;}
    public double getPeso(){return peso;} public void setPeso(double v){peso=v;}
    public double getTalla(){return talla;} public void setTalla(double v){talla=v;}
    public int getIdConsulta(){return idConsulta;} public void setIdConsulta(int v){idConsulta=v;}
    @Override public String toString(){return idSignoVital+" | Consulta #"+idConsulta+" | "+fecha+" | Temp "+temperatura+" | PA "+presionArterial+" | FC "+frecuenciaCardiaca+" | FR "+frecuenciaRespiratoria+" | Peso "+peso+" | Talla "+talla;}
}
