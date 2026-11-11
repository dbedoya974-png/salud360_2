package app.service.inputports;
import app.domain.Cita;
import java.util.List;
public interface CitaServiceInterface {
    Cita create(Cita entity);
    List<Cita> selectAll();
    Cita findById(int id);
    boolean update(Cita entity);
    boolean delete(int id);
}
