package app.domain;
import app.domain.enums.TipoDocumento;
public class Paciente {
    private int idPaciente;
    private TipoDocumento tipoDocumento;
    private String numeroDocumento;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String telefono;
    private String correo;
    private String direccion;
    public Paciente() {}
    public Paciente(int idPaciente, TipoDocumento tipoDocumento, String numeroDocumento, String nombre, String apellido,
                    String fechaNacimiento, String telefono, String correo, String direccion) {
        this.idPaciente=idPaciente; this.tipoDocumento=tipoDocumento; this.numeroDocumento=numeroDocumento;
        this.nombre=nombre; this.apellido=apellido; this.fechaNacimiento=fechaNacimiento; this.telefono=telefono;
        this.correo=correo; this.direccion=direccion;
    }
    public int getIdPaciente(){return idPaciente;} public void setIdPaciente(int v){idPaciente=v;}
    public TipoDocumento getTipoDocumento(){return tipoDocumento;} public void setTipoDocumento(TipoDocumento v){tipoDocumento=v;}
    public String getNumeroDocumento(){return numeroDocumento;} public void setNumeroDocumento(String v){numeroDocumento=v;}
    public String getNombre(){return nombre;} public void setNombre(String v){nombre=v;}
    public String getApellido(){return apellido;} public void setApellido(String v){apellido=v;}
    public String getFechaNacimiento(){return fechaNacimiento;} public void setFechaNacimiento(String v){fechaNacimiento=v;}
    public String getTelefono(){return telefono;} public void setTelefono(String v){telefono=v;}
    public String getCorreo(){return correo;} public void setCorreo(String v){correo=v;}
    public String getDireccion(){return direccion;} public void setDireccion(String v){direccion=v;}
    @Override public String toString(){return idPaciente+" | "+tipoDocumento+" "+numeroDocumento+" | "+nombre+" "+apellido+" | "+telefono+" | "+correo;}
}
