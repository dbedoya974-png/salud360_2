package app.repository;
import app.domain.Tratamiento;
import app.service.outputports.TratamientoRepositoryPort;
import java.util.ArrayList;
import java.util.List;
public class TratamientoRepositoryImp implements TratamientoRepositoryPort {
    private final List<Tratamiento> data = new ArrayList<>();
    @Override public Tratamiento create(Tratamiento entity) { data.add(entity); return entity; }
    @Override public List<Tratamiento> selectAll() { return new ArrayList<>(data); }
    @Override public Tratamiento findById(int id) {
        for (Tratamiento e : data) { if (e.getIdTratamiento() == id) return e; }
        return null;
    }
    @Override public boolean update(Tratamiento entity) {
        for (int i=0;i<data.size();i++) {
            if (data.get(i).getIdTratamiento() == entity.getIdTratamiento()) { data.set(i, entity); return true; }
        }
        return false;
    }
    @Override public boolean delete(int id) {
        return data.removeIf(e -> e.getIdTratamiento() == id);
    }
}
