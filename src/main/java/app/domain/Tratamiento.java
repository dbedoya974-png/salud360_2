package app.domain;
public class Tratamiento {
    private int idTratamiento; private String descripcion; private String fechaInicio; private String fechaFin; private String indicaciones; private int idConsulta;
    public Tratamiento(){} public Tratamiento(int idTratamiento,String descripcion,String fechaInicio,String fechaFin,String indicaciones,int idConsulta){this.idTratamiento=idTratamiento;this.descripcion=descripcion;this.fechaInicio=fechaInicio;this.fechaFin=fechaFin;this.indicaciones=indicaciones;this.idConsulta=idConsulta;}
    public int getIdTratamiento(){return idTratamiento;} public void setIdTratamiento(int v){idTratamiento=v;}
    public String getDescripcion(){return descripcion;} public void setDescripcion(String v){descripcion=v;}
    public String getFechaInicio(){return fechaInicio;} public void setFechaInicio(String v){fechaInicio=v;}
    public String getFechaFin(){return fechaFin;} public void setFechaFin(String v){fechaFin=v;}
    public String getIndicaciones(){return indicaciones;} public void setIndicaciones(String v){indicaciones=v;}
    public int getIdConsulta(){return idConsulta;} public void setIdConsulta(int v){idConsulta=v;}
    @Override public String toString(){return idTratamiento+" | Consulta #"+idConsulta+" | "+descripcion+" | "+fechaInicio+" - "+fechaFin+" | "+indicaciones;}
}
