package app.repository;

import app.domain.Profesional;
import app.repository.jdbc.JdbcCrudRepository;
import app.service.outputports.ProfesionalRepositoryPort;

/** Repositorio persistente de Profesional usando MariaDB/JDBC. */
public class ProfesionalRepositoryImp extends JdbcCrudRepository<Profesional> implements ProfesionalRepositoryPort {
    public ProfesionalRepositoryImp() {
        super(Profesional.class, "profesionales", "idProfesional");
    }
}
