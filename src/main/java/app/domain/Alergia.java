package app.domain;
import app.domain.enums.TipoAlergia;
public class Alergia {
    private int idAlergia; private String descripcion; private TipoAlergia tipo; private int idPaciente;
    public Alergia(){} public Alergia(int idAlergia,String descripcion,TipoAlergia tipo,int idPaciente){this.idAlergia=idAlergia;this.descripcion=descripcion;this.tipo=tipo;this.idPaciente=idPaciente;}
    public int getIdAlergia(){return idAlergia;} public void setIdAlergia(int v){idAlergia=v;}
    public String getDescripcion(){return descripcion;} public void setDescripcion(String v){descripcion=v;}
    public TipoAlergia getTipo(){return tipo;} public void setTipo(TipoAlergia v){tipo=v;}
    public int getIdPaciente(){return idPaciente;} public void setIdPaciente(int v){idPaciente=v;}
    @Override public String toString(){return idAlergia+" | Paciente #"+idPaciente+" | "+tipo+" | "+descripcion;}
}
