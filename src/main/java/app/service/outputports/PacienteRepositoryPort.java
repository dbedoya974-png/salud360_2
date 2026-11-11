package app.service.outputports;
import app.domain.Paciente;
import java.util.List;
public interface PacienteRepositoryPort {
    Paciente create(Paciente entity);
    List<Paciente> selectAll();
    Paciente findById(int id);
    boolean update(Paciente entity);
    boolean delete(int id);
}
