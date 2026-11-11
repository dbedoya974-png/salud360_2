package app.service.inputports;
import app.domain.Especialidad;
import java.util.List;
public interface EspecialidadServiceInterface {
    Especialidad create(Especialidad entity);
    List<Especialidad> selectAll();
    Especialidad findById(int id);
    boolean update(Especialidad entity);
    boolean delete(int id);
}
