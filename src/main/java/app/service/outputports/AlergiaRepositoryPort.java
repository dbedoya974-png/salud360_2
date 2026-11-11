package app.service.outputports;
import app.domain.Alergia;
import java.util.List;
public interface AlergiaRepositoryPort {
    Alergia create(Alergia entity);
    List<Alergia> selectAll();
    Alergia findById(int id);
    boolean update(Alergia entity);
    boolean delete(int id);
}
