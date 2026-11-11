package app.repository;
import app.domain.SignoVital;
import app.service.outputports.SignoVitalRepositoryPort;
import java.util.ArrayList;
import java.util.List;
public class SignoVitalRepositoryImp implements SignoVitalRepositoryPort {
    private final List<SignoVital> data = new ArrayList<>();
    @Override public SignoVital create(SignoVital entity) { data.add(entity); return entity; }
    @Override public List<SignoVital> selectAll() { return new ArrayList<>(data); }
    @Override public SignoVital findById(int id) {
        for (SignoVital e : data) { if (e.getIdSignoVital() == id) return e; }
        return null;
    }
    @Override public boolean update(SignoVital entity) {
        for (int i=0;i<data.size();i++) {
            if (data.get(i).getIdSignoVital() == entity.getIdSignoVital()) { data.set(i, entity); return true; }
        }
        return false;
    }
    @Override public boolean delete(int id) {
        return data.removeIf(e -> e.getIdSignoVital() == id);
    }
}
