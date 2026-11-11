package app.service.inputports;
import app.domain.Paciente;
import java.util.List;
public interface PacienteServiceInterface {
    Paciente create(Paciente entity);
    List<Paciente> selectAll();
    Paciente findById(int id);
    boolean update(Paciente entity);
    boolean delete(int id);
}
