package app.repository;

import app.domain.Alergia;
import app.repository.jdbc.JdbcCrudRepository;
import app.service.outputports.AlergiaRepositoryPort;

/** Repositorio persistente de Alergia usando MariaDB/JDBC. */
public class AlergiaRepositoryImp extends JdbcCrudRepository<Alergia> implements AlergiaRepositoryPort {
    public AlergiaRepositoryImp() {
        super(Alergia.class, "alergias", "idAlergia");
    }
}
