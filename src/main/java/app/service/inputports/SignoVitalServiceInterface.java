package app.service.inputports;
import app.domain.SignoVital;
import java.util.List;
public interface SignoVitalServiceInterface {
    SignoVital create(SignoVital entity);
    List<SignoVital> selectAll();
    SignoVital findById(int id);
    boolean update(SignoVital entity);
    boolean delete(int id);
}
