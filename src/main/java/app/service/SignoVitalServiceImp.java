package app.service;
import app.domain.SignoVital;
import app.service.inputports.SignoVitalServiceInterface;
import app.service.outputports.SignoVitalRepositoryPort;
import java.util.List;
public class SignoVitalServiceImp implements SignoVitalServiceInterface {
    private final SignoVitalRepositoryPort repository;
    public SignoVitalServiceImp(SignoVitalRepositoryPort repository) { this.repository = repository; }
    @Override public SignoVital create(SignoVital entity) { return repository.create(entity); }
    @Override public List<SignoVital> selectAll() { return repository.selectAll(); }
    @Override public SignoVital findById(int id) { return repository.findById(id); }
    @Override public boolean update(SignoVital entity) { return repository.update(entity); }
    @Override public boolean delete(int id) { return repository.delete(id); }
}
