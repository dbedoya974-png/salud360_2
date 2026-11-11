package app.domain;
public class Medicamento {
    private int idMedicamento; private String nombre; private String descripcion; private String presentacion;
    public Medicamento(){} public Medicamento(int idMedicamento,String nombre,String descripcion,String presentacion){this.idMedicamento=idMedicamento;this.nombre=nombre;this.descripcion=descripcion;this.presentacion=presentacion;}
    public int getIdMedicamento(){return idMedicamento;} public void setIdMedicamento(int v){idMedicamento=v;}
    public String getNombre(){return nombre;} public void setNombre(String v){nombre=v;}
    public String getDescripcion(){return descripcion;} public void setDescripcion(String v){descripcion=v;}
    public String getPresentacion(){return presentacion;} public void setPresentacion(String v){presentacion=v;}
    @Override public String toString(){return idMedicamento+" | "+nombre+" | "+presentacion+" | "+descripcion;}
}
