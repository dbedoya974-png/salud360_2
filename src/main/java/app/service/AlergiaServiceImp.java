package app.service;
import app.domain.Alergia;
import app.service.inputports.AlergiaServiceInterface;
import app.service.outputports.AlergiaRepositoryPort;
import java.util.List;
public class AlergiaServiceImp implements AlergiaServiceInterface {
    private final AlergiaRepositoryPort repository;
    public AlergiaServiceImp(AlergiaRepositoryPort repository) { this.repository = repository; }
    @Override public Alergia create(Alergia entity) { return repository.create(entity); }
    @Override public List<Alergia> selectAll() { return repository.selectAll(); }
    @Override public Alergia findById(int id) { return repository.findById(id); }
    @Override public boolean update(Alergia entity) { return repository.update(entity); }
    @Override public boolean delete(int id) { return repository.delete(id); }
}
