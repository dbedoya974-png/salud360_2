package app.service.outputports;
import app.domain.SignoVital;
import java.util.List;
public interface SignoVitalRepositoryPort {
    SignoVital create(SignoVital entity);
    List<SignoVital> selectAll();
    SignoVital findById(int id);
    boolean update(SignoVital entity);
    boolean delete(int id);
}
