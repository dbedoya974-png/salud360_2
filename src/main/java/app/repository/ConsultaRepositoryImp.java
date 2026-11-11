package app.repository;

import app.domain.Consulta;
import app.repository.jdbc.JdbcCrudRepository;
import app.service.outputports.ConsultaRepositoryPort;

/** Repositorio persistente de Consulta usando MariaDB/JDBC. */
public class ConsultaRepositoryImp extends JdbcCrudRepository<Consulta> implements ConsultaRepositoryPort {
    public ConsultaRepositoryImp() {
        super(Consulta.class, "consultas", "idConsulta");
    }
}
