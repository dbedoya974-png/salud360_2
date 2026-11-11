package app.service;
import app.domain.Medicamento;
import app.service.inputports.MedicamentoServiceInterface;
import app.service.outputports.MedicamentoRepositoryPort;
import java.util.List;
public class MedicamentoServiceImp implements MedicamentoServiceInterface {
    private final MedicamentoRepositoryPort repository;
    public MedicamentoServiceImp(MedicamentoRepositoryPort repository) { this.repository = repository; }
    @Override public Medicamento create(Medicamento entity) { return repository.create(entity); }
    @Override public List<Medicamento> selectAll() { return repository.selectAll(); }
    @Override public Medicamento findById(int id) { return repository.findById(id); }
    @Override public boolean update(Medicamento entity) { return repository.update(entity); }
    @Override public boolean delete(int id) { return repository.delete(id); }
}
