package app.service;
import app.domain.Cita;
import app.service.inputports.CitaServiceInterface;
import app.service.outputports.CitaRepositoryPort;
import java.util.List;
public class CitaServiceImp implements CitaServiceInterface {
    private final CitaRepositoryPort repository;
    public CitaServiceImp(CitaRepositoryPort repository) { this.repository = repository; }
    @Override public Cita create(Cita entity) { return repository.create(entity); }
    @Override public List<Cita> selectAll() { return repository.selectAll(); }
    @Override public Cita findById(int id) { return repository.findById(id); }
    @Override public boolean update(Cita entity) { return repository.update(entity); }
    @Override public boolean delete(int id) { return repository.delete(id); }
}
