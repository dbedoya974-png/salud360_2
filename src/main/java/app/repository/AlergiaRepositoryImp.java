package app.repository;
import app.domain.Alergia;
import app.service.outputports.AlergiaRepositoryPort;
import java.util.ArrayList;
import java.util.List;
public class AlergiaRepositoryImp implements AlergiaRepositoryPort {
    private final List<Alergia> data = new ArrayList<>();
    @Override public Alergia create(Alergia entity) { data.add(entity); return entity; }
    @Override public List<Alergia> selectAll() { return new ArrayList<>(data); }
    @Override public Alergia findById(int id) {
        for (Alergia e : data) { if (e.getIdAlergia() == id) return e; }
        return null;
    }
    @Override public boolean update(Alergia entity) {
        for (int i=0;i<data.size();i++) {
            if (data.get(i).getIdAlergia() == entity.getIdAlergia()) { data.set(i, entity); return true; }
        }
        return false;
    }
    @Override public boolean delete(int id) {
        return data.removeIf(e -> e.getIdAlergia() == id);
    }
}
