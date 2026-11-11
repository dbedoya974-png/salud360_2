package app.repository;
import app.domain.Profesional;
import app.service.outputports.ProfesionalRepositoryPort;
import java.util.ArrayList;
import java.util.List;
public class ProfesionalRepositoryImp implements ProfesionalRepositoryPort {
    private final List<Profesional> data = new ArrayList<>();
    @Override public Profesional create(Profesional entity) { data.add(entity); return entity; }
    @Override public List<Profesional> selectAll() { return new ArrayList<>(data); }
    @Override public Profesional findById(int id) {
        for (Profesional e : data) { if (e.getIdProfesional() == id) return e; }
        return null;
    }
    @Override public boolean update(Profesional entity) {
        for (int i=0;i<data.size();i++) {
            if (data.get(i).getIdProfesional() == entity.getIdProfesional()) { data.set(i, entity); return true; }
        }
        return false;
    }
    @Override public boolean delete(int id) {
        return data.removeIf(e -> e.getIdProfesional() == id);
    }
}
