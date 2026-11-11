package app.repository;

import app.domain.Especialidad;
import app.repository.jdbc.JdbcCrudRepository;
import app.service.outputports.EspecialidadRepositoryPort;

/** Repositorio persistente de Especialidad usando MariaDB/JDBC. */
public class EspecialidadRepositoryImp extends JdbcCrudRepository<Especialidad> implements EspecialidadRepositoryPort {
    public EspecialidadRepositoryImp() {
        super(Especialidad.class, "especialidades", "idEspecialidad");
    }
}
