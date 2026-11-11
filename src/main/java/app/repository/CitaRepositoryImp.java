package app.repository;

import app.domain.Cita;
import app.repository.jdbc.JdbcCrudRepository;
import app.service.outputports.CitaRepositoryPort;

/** Repositorio persistente de Cita usando MariaDB/JDBC. */
public class CitaRepositoryImp extends JdbcCrudRepository<Cita> implements CitaRepositoryPort {
    public CitaRepositoryImp() {
        super(Cita.class, "citas", "idCita");
    }
}
