package app.repository;

import app.domain.Medicamento;
import app.repository.jdbc.JdbcCrudRepository;
import app.service.outputports.MedicamentoRepositoryPort;

/** Repositorio persistente de Medicamento usando MariaDB/JDBC. */
public class MedicamentoRepositoryImp extends JdbcCrudRepository<Medicamento> implements MedicamentoRepositoryPort {
    public MedicamentoRepositoryImp() {
        super(Medicamento.class, "medicamentos", "idMedicamento");
    }
}
