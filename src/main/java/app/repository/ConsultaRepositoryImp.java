package app.repository;
import app.domain.Consulta;
import app.service.outputports.ConsultaRepositoryPort;
import java.util.ArrayList;
import java.util.List;
public class ConsultaRepositoryImp implements ConsultaRepositoryPort {
    private final List<Consulta> data = new ArrayList<>();
    @Override public Consulta create(Consulta entity) { data.add(entity); return entity; }
    @Override public List<Consulta> selectAll() { return new ArrayList<>(data); }
    @Override public Consulta findById(int id) {
        for (Consulta e : data) { if (e.getIdConsulta() == id) return e; }
        return null;
    }
    @Override public boolean update(Consulta entity) {
        for (int i=0;i<data.size();i++) {
            if (data.get(i).getIdConsulta() == entity.getIdConsulta()) { data.set(i, entity); return true; }
        }
        return false;
    }
    @Override public boolean delete(int id) {
        return data.removeIf(e -> e.getIdConsulta() == id);
    }
}
