package app.service.inputports;
import app.domain.Profesional;
import java.util.List;
public interface ProfesionalServiceInterface {
    Profesional create(Profesional entity);
    List<Profesional> selectAll();
    Profesional findById(int id);
    boolean update(Profesional entity);
    boolean delete(int id);
}
