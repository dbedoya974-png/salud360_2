package app.service.outputports;
import app.domain.Tratamiento;
import java.util.List;
public interface TratamientoRepositoryPort {
    Tratamiento create(Tratamiento entity);
    List<Tratamiento> selectAll();
    Tratamiento findById(int id);
    boolean update(Tratamiento entity);
    boolean delete(int id);
}
