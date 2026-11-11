package app.service;
import app.domain.AntecedenteMedico;
import app.service.inputports.AntecedenteMedicoServiceInterface;
import app.service.outputports.AntecedenteMedicoRepositoryPort;
import java.util.List;
public class AntecedenteMedicoServiceImp implements AntecedenteMedicoServiceInterface {
    private final AntecedenteMedicoRepositoryPort repository;
    public AntecedenteMedicoServiceImp(AntecedenteMedicoRepositoryPort repository) { this.repository = repository; }
    @Override public AntecedenteMedico create(AntecedenteMedico entity) { return repository.create(entity); }
    @Override public List<AntecedenteMedico> selectAll() { return repository.selectAll(); }
    @Override public AntecedenteMedico findById(int id) { return repository.findById(id); }
    @Override public boolean update(AntecedenteMedico entity) { return repository.update(entity); }
    @Override public boolean delete(int id) { return repository.delete(id); }
}
