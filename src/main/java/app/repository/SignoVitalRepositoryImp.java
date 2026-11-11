package app.repository;

import app.domain.SignoVital;
import app.repository.jdbc.JdbcCrudRepository;
import app.service.outputports.SignoVitalRepositoryPort;

/** Repositorio persistente de SignoVital usando MariaDB/JDBC. */
public class SignoVitalRepositoryImp extends JdbcCrudRepository<SignoVital> implements SignoVitalRepositoryPort {
    public SignoVitalRepositoryImp() {
        super(SignoVital.class, "signos_vitales", "idSignoVital");
    }
}
