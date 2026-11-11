package app.service;
import app.domain.Profesional;
import app.service.inputports.ProfesionalServiceInterface;
import app.service.outputports.ProfesionalRepositoryPort;
import java.util.List;
public class ProfesionalServiceImp implements ProfesionalServiceInterface {
    private final ProfesionalRepositoryPort repository;
    public ProfesionalServiceImp(ProfesionalRepositoryPort repository) { this.repository = repository; }
    @Override public Profesional create(Profesional entity) { return repository.create(entity); }
    @Override public List<Profesional> selectAll() { return repository.selectAll(); }
    @Override public Profesional findById(int id) { return repository.findById(id); }
    @Override public boolean update(Profesional entity) { return repository.update(entity); }
    @Override public boolean delete(int id) { return repository.delete(id); }
}
