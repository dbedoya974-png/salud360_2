package app.service;
import app.domain.Diagnostico;
import app.service.inputports.DiagnosticoServiceInterface;
import app.service.outputports.DiagnosticoRepositoryPort;
import java.util.List;
public class DiagnosticoServiceImp implements DiagnosticoServiceInterface {
    private final DiagnosticoRepositoryPort repository;
    public DiagnosticoServiceImp(DiagnosticoRepositoryPort repository) { this.repository = repository; }
    @Override public Diagnostico create(Diagnostico entity) { return repository.create(entity); }
    @Override public List<Diagnostico> selectAll() { return repository.selectAll(); }
    @Override public Diagnostico findById(int id) { return repository.findById(id); }
    @Override public boolean update(Diagnostico entity) { return repository.update(entity); }
    @Override public boolean delete(int id) { return repository.delete(id); }
}
