package app.repository;
import app.domain.Diagnostico;
import app.service.outputports.DiagnosticoRepositoryPort;
import java.util.ArrayList;
import java.util.List;
public class DiagnosticoRepositoryImp implements DiagnosticoRepositoryPort {
    private final List<Diagnostico> data = new ArrayList<>();
    @Override public Diagnostico create(Diagnostico entity) { data.add(entity); return entity; }
    @Override public List<Diagnostico> selectAll() { return new ArrayList<>(data); }
    @Override public Diagnostico findById(int id) {
        for (Diagnostico e : data) { if (e.getIdDiagnostico() == id) return e; }
        return null;
    }
    @Override public boolean update(Diagnostico entity) {
        for (int i=0;i<data.size();i++) {
            if (data.get(i).getIdDiagnostico() == entity.getIdDiagnostico()) { data.set(i, entity); return true; }
        }
        return false;
    }
    @Override public boolean delete(int id) {
        return data.removeIf(e -> e.getIdDiagnostico() == id);
    }
}
