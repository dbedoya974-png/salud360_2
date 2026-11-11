package app.repository;
import app.domain.Especialidad;
import app.service.outputports.EspecialidadRepositoryPort;
import java.util.ArrayList;
import java.util.List;
public class EspecialidadRepositoryImp implements EspecialidadRepositoryPort {
    private final List<Especialidad> data = new ArrayList<>();
    @Override public Especialidad create(Especialidad entity) { data.add(entity); return entity; }
    @Override public List<Especialidad> selectAll() { return new ArrayList<>(data); }
    @Override public Especialidad findById(int id) {
        for (Especialidad e : data) { if (e.getIdEspecialidad() == id) return e; }
        return null;
    }
    @Override public boolean update(Especialidad entity) {
        for (int i=0;i<data.size();i++) {
            if (data.get(i).getIdEspecialidad() == entity.getIdEspecialidad()) { data.set(i, entity); return true; }
        }
        return false;
    }
    @Override public boolean delete(int id) {
        return data.removeIf(e -> e.getIdEspecialidad() == id);
    }
}
