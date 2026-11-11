package app.repository;
import app.domain.Cita;
import app.service.outputports.CitaRepositoryPort;
import java.util.ArrayList;
import java.util.List;
public class CitaRepositoryImp implements CitaRepositoryPort {
    private final List<Cita> data = new ArrayList<>();
    @Override public Cita create(Cita entity) { data.add(entity); return entity; }
    @Override public List<Cita> selectAll() { return new ArrayList<>(data); }
    @Override public Cita findById(int id) {
        for (Cita e : data) { if (e.getIdCita() == id) return e; }
        return null;
    }
    @Override public boolean update(Cita entity) {
        for (int i=0;i<data.size();i++) {
            if (data.get(i).getIdCita() == entity.getIdCita()) { data.set(i, entity); return true; }
        }
        return false;
    }
    @Override public boolean delete(int id) {
        return data.removeIf(e -> e.getIdCita() == id);
    }
}
