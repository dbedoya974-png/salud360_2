package app.domain;
public class Consulta {
    private int idConsulta; private String fecha; private String motivo; private String observaciones; private int idCita; private int idHistoria;
    public Consulta(){} public Consulta(int idConsulta,String fecha,String motivo,String observaciones,int idCita,int idHistoria){this.idConsulta=idConsulta;this.fecha=fecha;this.motivo=motivo;this.observaciones=observaciones;this.idCita=idCita;this.idHistoria=idHistoria;}
    public int getIdConsulta(){return idConsulta;} public void setIdConsulta(int v){idConsulta=v;}
    public String getFecha(){return fecha;} public void setFecha(String v){fecha=v;}
    public String getMotivo(){return motivo;} public void setMotivo(String v){motivo=v;}
    public String getObservaciones(){return observaciones;} public void setObservaciones(String v){observaciones=v;}
    public int getIdCita(){return idCita;} public void setIdCita(int v){idCita=v;}
    public int getIdHistoria(){return idHistoria;} public void setIdHistoria(int v){idHistoria=v;}
    @Override public String toString(){return idConsulta+" | "+fecha+" | Cita #"+idCita+" | Historia #"+idHistoria+" | "+motivo+" | "+observaciones;}
}
