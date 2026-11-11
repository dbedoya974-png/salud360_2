package app.repository;
import app.domain.Paciente;
import app.service.outputports.PacienteRepositoryPort;
import java.util.ArrayList;
import java.util.List;
public class PacienteRepositoryImp implements PacienteRepositoryPort {
    private final List<Paciente> data = new ArrayList<>();
    @Override public Paciente create(Paciente entity) { data.add(entity); return entity; }
    @Override public List<Paciente> selectAll() { return new ArrayList<>(data); }
    @Override public Paciente findById(int id) {
        for (Paciente e : data) { if (e.getIdPaciente() == id) return e; }
        return null;
    }
    @Override public boolean update(Paciente entity) {
        for (int i=0;i<data.size();i++) {
            if (data.get(i).getIdPaciente() == entity.getIdPaciente()) { data.set(i, entity); return true; }
        }
        return false;
    }
    @Override public boolean delete(int id) {
        return data.removeIf(e -> e.getIdPaciente() == id);
    }
}
