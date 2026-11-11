package app.domain;
public class Especialidad {
    private int idEspecialidad; private String nombre; private String descripcion;
    public Especialidad(){} public Especialidad(int idEspecialidad,String nombre,String descripcion){this.idEspecialidad=idEspecialidad;this.nombre=nombre;this.descripcion=descripcion;}
    public int getIdEspecialidad(){return idEspecialidad;} public void setIdEspecialidad(int v){idEspecialidad=v;}
    public String getNombre(){return nombre;} public void setNombre(String v){nombre=v;}
    public String getDescripcion(){return descripcion;} public void setDescripcion(String v){descripcion=v;}
    @Override public String toString(){return idEspecialidad+" | "+nombre+" | "+descripcion;}
}
