package app.service.inputports;
import app.domain.Tratamiento;
import java.util.List;
public interface TratamientoServiceInterface {
    Tratamiento create(Tratamiento entity);
    List<Tratamiento> selectAll();
    Tratamiento findById(int id);
    boolean update(Tratamiento entity);
    boolean delete(int id);
}
