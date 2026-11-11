package app.service.outputports;
import app.domain.HistoriaClinica;
import java.util.List;
public interface HistoriaClinicaRepositoryPort {
    HistoriaClinica create(HistoriaClinica entity);
    List<HistoriaClinica> selectAll();
    HistoriaClinica findById(int id);
    boolean update(HistoriaClinica entity);
    boolean delete(int id);
}
