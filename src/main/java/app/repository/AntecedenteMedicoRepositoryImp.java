package app.repository;
import app.domain.AntecedenteMedico;
import app.service.outputports.AntecedenteMedicoRepositoryPort;
import java.util.ArrayList;
import java.util.List;
public class AntecedenteMedicoRepositoryImp implements AntecedenteMedicoRepositoryPort {
    private final List<AntecedenteMedico> data = new ArrayList<>();
    @Override public AntecedenteMedico create(AntecedenteMedico entity) { data.add(entity); return entity; }
    @Override public List<AntecedenteMedico> selectAll() { return new ArrayList<>(data); }
    @Override public AntecedenteMedico findById(int id) {
        for (AntecedenteMedico e : data) { if (e.getIdAntecedente() == id) return e; }
        return null;
    }
    @Override public boolean update(AntecedenteMedico entity) {
        for (int i=0;i<data.size();i++) {
            if (data.get(i).getIdAntecedente() == entity.getIdAntecedente()) { data.set(i, entity); return true; }
        }
        return false;
    }
    @Override public boolean delete(int id) {
        return data.removeIf(e -> e.getIdAntecedente() == id);
    }
}
