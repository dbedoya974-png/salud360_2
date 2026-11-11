package app.domain;
public class Diagnostico {
    private int idDiagnostico; private String descripcion; private String fecha; private int idConsulta;
    public Diagnostico(){} public Diagnostico(int idDiagnostico,String descripcion,String fecha,int idConsulta){this.idDiagnostico=idDiagnostico;this.descripcion=descripcion;this.fecha=fecha;this.idConsulta=idConsulta;}
    public int getIdDiagnostico(){return idDiagnostico;} public void setIdDiagnostico(int v){idDiagnostico=v;}
    public String getDescripcion(){return descripcion;} public void setDescripcion(String v){descripcion=v;}
    public String getFecha(){return fecha;} public void setFecha(String v){fecha=v;}
    public int getIdConsulta(){return idConsulta;} public void setIdConsulta(int v){idConsulta=v;}
    @Override public String toString(){return idDiagnostico+" | Consulta #"+idConsulta+" | "+fecha+" | "+descripcion;}
}
