package app.domain;
public class HistoriaClinica {
    private int idHistoria; private String fechaApertura; private String observaciones; private int idPaciente;
    public HistoriaClinica(){} public HistoriaClinica(int idHistoria,String fechaApertura,String observaciones,int idPaciente){this.idHistoria=idHistoria;this.fechaApertura=fechaApertura;this.observaciones=observaciones;this.idPaciente=idPaciente;}
    public int getIdHistoria(){return idHistoria;} public void setIdHistoria(int v){idHistoria=v;}
    public String getFechaApertura(){return fechaApertura;} public void setFechaApertura(String v){fechaApertura=v;}
    public String getObservaciones(){return observaciones;} public void setObservaciones(String v){observaciones=v;}
    public int getIdPaciente(){return idPaciente;} public void setIdPaciente(int v){idPaciente=v;}
    @Override public String toString(){return idHistoria+" | Paciente #"+idPaciente+" | Apertura: "+fechaApertura+" | "+observaciones;}
}
