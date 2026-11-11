package app.domain;
import app.domain.enums.TipoDocumento;
public class Profesional {
    private int idProfesional; private TipoDocumento tipoDocumento; private String numeroDocumento;
    private String nombre; private String apellido; private String telefono; private String correo;
    private String registroProfesional; private int idEspecialidad;
    public Profesional(){}
    public Profesional(int idProfesional, TipoDocumento tipoDocumento, String numeroDocumento, String nombre, String apellido,
                        String telefono, String correo, String registroProfesional, int idEspecialidad){
        this.idProfesional=idProfesional;this.tipoDocumento=tipoDocumento;this.numeroDocumento=numeroDocumento;
        this.nombre=nombre;this.apellido=apellido;this.telefono=telefono;this.correo=correo;
        this.registroProfesional=registroProfesional;this.idEspecialidad=idEspecialidad;
    }
    public int getIdProfesional(){return idProfesional;} public void setIdProfesional(int v){idProfesional=v;}
    public TipoDocumento getTipoDocumento(){return tipoDocumento;} public void setTipoDocumento(TipoDocumento v){tipoDocumento=v;}
    public String getNumeroDocumento(){return numeroDocumento;} public void setNumeroDocumento(String v){numeroDocumento=v;}
    public String getNombre(){return nombre;} public void setNombre(String v){nombre=v;}
    public String getApellido(){return apellido;} public void setApellido(String v){apellido=v;}
    public String getTelefono(){return telefono;} public void setTelefono(String v){telefono=v;}
    public String getCorreo(){return correo;} public void setCorreo(String v){correo=v;}
    public String getRegistroProfesional(){return registroProfesional;} public void setRegistroProfesional(String v){registroProfesional=v;}
    public int getIdEspecialidad(){return idEspecialidad;} public void setIdEspecialidad(int v){idEspecialidad=v;}
    @Override public String toString(){return idProfesional+" | "+tipoDocumento+" "+numeroDocumento+" | "+nombre+" "+apellido+" | Especialidad #"+idEspecialidad+" | "+registroProfesional;}
}
