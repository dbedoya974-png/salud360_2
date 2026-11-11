package app.repository;

import app.domain.HistoriaClinica;
import app.repository.jdbc.JdbcCrudRepository;
import app.service.outputports.HistoriaClinicaRepositoryPort;

/** Repositorio persistente de HistoriaClinica usando MariaDB/JDBC. */
public class HistoriaClinicaRepositoryImp extends JdbcCrudRepository<HistoriaClinica> implements HistoriaClinicaRepositoryPort {
    public HistoriaClinicaRepositoryImp() {
        super(HistoriaClinica.class, "historias_clinicas", "idHistoria");
    }
}
