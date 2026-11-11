package app.service.outputports;
import app.domain.Medicamento;
import java.util.List;
public interface MedicamentoRepositoryPort {
    Medicamento create(Medicamento entity);
    List<Medicamento> selectAll();
    Medicamento findById(int id);
    boolean update(Medicamento entity);
    boolean delete(int id);
}
