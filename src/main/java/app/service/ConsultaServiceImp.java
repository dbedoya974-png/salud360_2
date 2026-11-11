package app.service;
import app.domain.Consulta;
import app.service.inputports.ConsultaServiceInterface;
import app.service.outputports.ConsultaRepositoryPort;
import java.util.List;
public class ConsultaServiceImp implements ConsultaServiceInterface {
    private final ConsultaRepositoryPort repository;
    public ConsultaServiceImp(ConsultaRepositoryPort repository) { this.repository = repository; }
    @Override public Consulta create(Consulta entity) { return repository.create(entity); }
    @Override public List<Consulta> selectAll() { return repository.selectAll(); }
    @Override public Consulta findById(int id) { return repository.findById(id); }
    @Override public boolean update(Consulta entity) { return repository.update(entity); }
    @Override public boolean delete(int id) { return repository.delete(id); }
}
