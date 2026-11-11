package app.repository;

import app.domain.Paciente;
import app.repository.jdbc.JdbcCrudRepository;
import app.service.outputports.PacienteRepositoryPort;

/** Repositorio persistente de Paciente usando MariaDB/JDBC. */
public class PacienteRepositoryImp extends JdbcCrudRepository<Paciente> implements PacienteRepositoryPort {
    public PacienteRepositoryImp() {
        super(Paciente.class, "pacientes", "idPaciente");
    }
}
