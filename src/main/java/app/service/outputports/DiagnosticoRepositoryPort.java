package app.service.outputports;
import app.domain.Diagnostico;
import java.util.List;
public interface DiagnosticoRepositoryPort {
    Diagnostico create(Diagnostico entity);
    List<Diagnostico> selectAll();
    Diagnostico findById(int id);
    boolean update(Diagnostico entity);
    boolean delete(int id);
}
