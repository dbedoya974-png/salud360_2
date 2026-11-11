package app.service.inputports;
import app.domain.AntecedenteMedico;
import java.util.List;
public interface AntecedenteMedicoServiceInterface {
    AntecedenteMedico create(AntecedenteMedico entity);
    List<AntecedenteMedico> selectAll();
    AntecedenteMedico findById(int id);
    boolean update(AntecedenteMedico entity);
    boolean delete(int id);
}
