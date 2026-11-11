package app.repository;

import app.domain.Diagnostico;
import app.repository.jdbc.JdbcCrudRepository;
import app.service.outputports.DiagnosticoRepositoryPort;

/** Repositorio persistente de Diagnostico usando MariaDB/JDBC. */
public class DiagnosticoRepositoryImp extends JdbcCrudRepository<Diagnostico> implements DiagnosticoRepositoryPort {
    public DiagnosticoRepositoryImp() {
        super(Diagnostico.class, "diagnosticos", "idDiagnostico");
    }
}
