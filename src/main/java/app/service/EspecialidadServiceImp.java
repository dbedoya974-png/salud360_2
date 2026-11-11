package app.service;
import app.domain.Especialidad;
import app.service.inputports.EspecialidadServiceInterface;
import app.service.outputports.EspecialidadRepositoryPort;
import java.util.List;
public class EspecialidadServiceImp implements EspecialidadServiceInterface {
    private final EspecialidadRepositoryPort repository;
    public EspecialidadServiceImp(EspecialidadRepositoryPort repository) { this.repository = repository; }
    @Override public Especialidad create(Especialidad entity) { return repository.create(entity); }
    @Override public List<Especialidad> selectAll() { return repository.selectAll(); }
    @Override public Especialidad findById(int id) { return repository.findById(id); }
    @Override public boolean update(Especialidad entity) { return repository.update(entity); }
    @Override public boolean delete(int id) { return repository.delete(id); }
}
