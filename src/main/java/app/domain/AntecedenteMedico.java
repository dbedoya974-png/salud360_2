package app.domain;
import app.domain.enums.TipoAntecedente;
public class AntecedenteMedico {
    private int idAntecedente; private String descripcion; private String fecha; private TipoAntecedente tipo; private int idPaciente;
    public AntecedenteMedico(){} public AntecedenteMedico(int idAntecedente,String descripcion,String fecha,TipoAntecedente tipo,int idPaciente){this.idAntecedente=idAntecedente;this.descripcion=descripcion;this.fecha=fecha;this.tipo=tipo;this.idPaciente=idPaciente;}
    public int getIdAntecedente(){return idAntecedente;} public void setIdAntecedente(int v){idAntecedente=v;}
    public String getDescripcion(){return descripcion;} public void setDescripcion(String v){descripcion=v;}
    public String getFecha(){return fecha;} public void setFecha(String v){fecha=v;}
    public TipoAntecedente getTipo(){return tipo;} public void setTipo(TipoAntecedente v){tipo=v;}
    public int getIdPaciente(){return idPaciente;} public void setIdPaciente(int v){idPaciente=v;}
    @Override public String toString(){return idAntecedente+" | Paciente #"+idPaciente+" | "+tipo+" | "+fecha+" | "+descripcion;}
}
