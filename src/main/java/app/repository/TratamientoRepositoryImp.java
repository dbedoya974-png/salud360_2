package app.repository;

import app.domain.Tratamiento;
import app.repository.jdbc.JdbcCrudRepository;
import app.service.outputports.TratamientoRepositoryPort;

/** Repositorio persistente de Tratamiento usando MariaDB/JDBC. */
public class TratamientoRepositoryImp extends JdbcCrudRepository<Tratamiento> implements TratamientoRepositoryPort {
    public TratamientoRepositoryImp() {
        super(Tratamiento.class, "tratamientos", "idTratamiento");
    }
}
