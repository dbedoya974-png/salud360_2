package app.service;
import app.domain.Paciente;
import app.service.inputports.PacienteServiceInterface;
import app.service.outputports.PacienteRepositoryPort;
import java.util.List;
public class PacienteServiceImp implements PacienteServiceInterface {
    private final PacienteRepositoryPort repository;
    public PacienteServiceImp(PacienteRepositoryPort repository) { this.repository = repository; }
    @Override public Paciente create(Paciente entity) { return repository.create(entity); }
    @Override public List<Paciente> selectAll() { return repository.selectAll(); }
    @Override public Paciente findById(int id) { return repository.findById(id); }
    @Override public boolean update(Paciente entity) { return repository.update(entity); }
    @Override public boolean delete(int id) { return repository.delete(id); }
}
