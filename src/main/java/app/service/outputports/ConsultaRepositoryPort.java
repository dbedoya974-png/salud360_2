package app.service.outputports;
import app.domain.Consulta;
import java.util.List;
public interface ConsultaRepositoryPort {
    Consulta create(Consulta entity);
    List<Consulta> selectAll();
    Consulta findById(int id);
    boolean update(Consulta entity);
    boolean delete(int id);
}
