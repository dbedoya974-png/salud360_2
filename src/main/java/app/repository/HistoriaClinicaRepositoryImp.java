package app.repository;
import app.domain.HistoriaClinica;
import app.service.outputports.HistoriaClinicaRepositoryPort;
import java.util.ArrayList;
import java.util.List;
public class HistoriaClinicaRepositoryImp implements HistoriaClinicaRepositoryPort {
    private final List<HistoriaClinica> data = new ArrayList<>();
    @Override public HistoriaClinica create(HistoriaClinica entity) { data.add(entity); return entity; }
    @Override public List<HistoriaClinica> selectAll() { return new ArrayList<>(data); }
    @Override public HistoriaClinica findById(int id) {
        for (HistoriaClinica e : data) { if (e.getIdHistoria() == id) return e; }
        return null;
    }
    @Override public boolean update(HistoriaClinica entity) {
        for (int i=0;i<data.size();i++) {
            if (data.get(i).getIdHistoria() == entity.getIdHistoria()) { data.set(i, entity); return true; }
        }
        return false;
    }
    @Override public boolean delete(int id) {
        return data.removeIf(e -> e.getIdHistoria() == id);
    }
}
