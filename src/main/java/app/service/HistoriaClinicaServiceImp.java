package app.service;
import app.domain.HistoriaClinica;
import app.service.inputports.HistoriaClinicaServiceInterface;
import app.service.outputports.HistoriaClinicaRepositoryPort;
import java.util.List;
public class HistoriaClinicaServiceImp implements HistoriaClinicaServiceInterface {
    private final HistoriaClinicaRepositoryPort repository;
    public HistoriaClinicaServiceImp(HistoriaClinicaRepositoryPort repository) { this.repository = repository; }
    @Override public HistoriaClinica create(HistoriaClinica entity) { return repository.create(entity); }
    @Override public List<HistoriaClinica> selectAll() { return repository.selectAll(); }
    @Override public HistoriaClinica findById(int id) { return repository.findById(id); }
    @Override public boolean update(HistoriaClinica entity) { return repository.update(entity); }
    @Override public boolean delete(int id) { return repository.delete(id); }
}
