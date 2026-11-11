package app.repository;
import app.domain.Medicamento;
import app.service.outputports.MedicamentoRepositoryPort;
import java.util.ArrayList;
import java.util.List;
public class MedicamentoRepositoryImp implements MedicamentoRepositoryPort {
    private final List<Medicamento> data = new ArrayList<>();
    @Override public Medicamento create(Medicamento entity) { data.add(entity); return entity; }
    @Override public List<Medicamento> selectAll() { return new ArrayList<>(data); }
    @Override public Medicamento findById(int id) {
        for (Medicamento e : data) { if (e.getIdMedicamento() == id) return e; }
        return null;
    }
    @Override public boolean update(Medicamento entity) {
        for (int i=0;i<data.size();i++) {
            if (data.get(i).getIdMedicamento() == entity.getIdMedicamento()) { data.set(i, entity); return true; }
        }
        return false;
    }
    @Override public boolean delete(int id) {
        return data.removeIf(e -> e.getIdMedicamento() == id);
    }
}
