package app.domain;
import app.domain.enums.EstadoCita;
public class Cita {
    private int idCita; private String fecha; private String hora; private String motivo; private EstadoCita estado;
    private int idPaciente; private int idProfesional;
    public Cita(){} public Cita(int idCita,String fecha,String hora,String motivo,EstadoCita estado,int idPaciente,int idProfesional){
        this.idCita=idCita;this.fecha=fecha;this.hora=hora;this.motivo=motivo;this.estado=estado;this.idPaciente=idPaciente;this.idProfesional=idProfesional;
    }
    public int getIdCita(){return idCita;} public void setIdCita(int v){idCita=v;}
    public String getFecha(){return fecha;} public void setFecha(String v){fecha=v;}
    public String getHora(){return hora;} public void setHora(String v){hora=v;}
    public String getMotivo(){return motivo;} public void setMotivo(String v){motivo=v;}
    public EstadoCita getEstado(){return estado;} public void setEstado(EstadoCita v){estado=v;}
    public int getIdPaciente(){return idPaciente;} public void setIdPaciente(int v){idPaciente=v;}
    public int getIdProfesional(){return idProfesional;} public void setIdProfesional(int v){idProfesional=v;}
    @Override public String toString(){return idCita+" | "+fecha+" "+hora+" | Paciente #"+idPaciente+" | Profesional #"+idProfesional+" | "+estado+" | "+motivo;}
}
