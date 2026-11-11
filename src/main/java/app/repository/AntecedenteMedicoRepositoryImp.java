package app.repository;

import app.domain.AntecedenteMedico;
import app.repository.jdbc.JdbcCrudRepository;
import app.service.outputports.AntecedenteMedicoRepositoryPort;

/** Repositorio persistente de AntecedenteMedico usando MariaDB/JDBC. */
public class AntecedenteMedicoRepositoryImp extends JdbcCrudRepository<AntecedenteMedico> implements AntecedenteMedicoRepositoryPort {
    public AntecedenteMedicoRepositoryImp() {
        super(AntecedenteMedico.class, "antecedentes_medicos", "idAntecedente");
    }
}
