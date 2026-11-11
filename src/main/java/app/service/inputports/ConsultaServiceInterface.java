package app.service.inputports;
import app.domain.Consulta;
import java.util.List;
public interface ConsultaServiceInterface {
    Consulta create(Consulta entity);
    List<Consulta> selectAll();
    Consulta findById(int id);
    boolean update(Consulta entity);
    boolean delete(int id);
}
