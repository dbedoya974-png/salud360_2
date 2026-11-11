package app.service;
import app.domain.Tratamiento;
import app.service.inputports.TratamientoServiceInterface;
import app.service.outputports.TratamientoRepositoryPort;
import java.util.List;
public class TratamientoServiceImp implements TratamientoServiceInterface {
    private final TratamientoRepositoryPort repository;
    public TratamientoServiceImp(TratamientoRepositoryPort repository) { this.repository = repository; }
    @Override public Tratamiento create(Tratamiento entity) { return repository.create(entity); }
    @Override public List<Tratamiento> selectAll() { return repository.selectAll(); }
    @Override public Tratamiento findById(int id) { return repository.findById(id); }
    @Override public boolean update(Tratamiento entity) { return repository.update(entity); }
    @Override public boolean delete(int id) { return repository.delete(id); }
}
