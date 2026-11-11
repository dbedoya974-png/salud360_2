package app;

import app.repository.*;
import app.service.*;
import app.service.inputports.*;
import app.service.outputports.*;
import app.ui.UserInterface;
import app.view.*;

public class Application {
    public static void main(String[] args) {
        PacienteRepositoryPort pacienteRepository = new PacienteRepositoryImp();
        PacienteServiceInterface pacienteService = new PacienteServiceImp(pacienteRepository);
        PacienteView pacienteView = new PacienteView(pacienteService);
        ProfesionalRepositoryPort profesionalRepository = new ProfesionalRepositoryImp();
        ProfesionalServiceInterface profesionalService = new ProfesionalServiceImp(profesionalRepository);
        ProfesionalView profesionalView = new ProfesionalView(profesionalService);
        EspecialidadRepositoryPort especialidadRepository = new EspecialidadRepositoryImp();
        EspecialidadServiceInterface especialidadService = new EspecialidadServiceImp(especialidadRepository);
        EspecialidadView especialidadView = new EspecialidadView(especialidadService);
        CitaRepositoryPort citaRepository = new CitaRepositoryImp();
        CitaServiceInterface citaService = new CitaServiceImp(citaRepository);
        CitaView citaView = new CitaView(citaService);
        HistoriaClinicaRepositoryPort historiaClinicaRepository = new HistoriaClinicaRepositoryImp();
        HistoriaClinicaServiceInterface historiaClinicaService = new HistoriaClinicaServiceImp(historiaClinicaRepository);
        HistoriaClinicaView historiaClinicaView = new HistoriaClinicaView(historiaClinicaService);
        ConsultaRepositoryPort consultaRepository = new ConsultaRepositoryImp();
        ConsultaServiceInterface consultaService = new ConsultaServiceImp(consultaRepository);
        ConsultaView consultaView = new ConsultaView(consultaService);
        DiagnosticoRepositoryPort diagnosticoRepository = new DiagnosticoRepositoryImp();
        DiagnosticoServiceInterface diagnosticoService = new DiagnosticoServiceImp(diagnosticoRepository);
        DiagnosticoView diagnosticoView = new DiagnosticoView(diagnosticoService);
        TratamientoRepositoryPort tratamientoRepository = new TratamientoRepositoryImp();
        TratamientoServiceInterface tratamientoService = new TratamientoServiceImp(tratamientoRepository);
        TratamientoView tratamientoView = new TratamientoView(tratamientoService);
        MedicamentoRepositoryPort medicamentoRepository = new MedicamentoRepositoryImp();
        MedicamentoServiceInterface medicamentoService = new MedicamentoServiceImp(medicamentoRepository);
        MedicamentoView medicamentoView = new MedicamentoView(medicamentoService);
        SignoVitalRepositoryPort signoVitalRepository = new SignoVitalRepositoryImp();
        SignoVitalServiceInterface signoVitalService = new SignoVitalServiceImp(signoVitalRepository);
        SignoVitalView signoVitalView = new SignoVitalView(signoVitalService);
        AlergiaRepositoryPort alergiaRepository = new AlergiaRepositoryImp();
        AlergiaServiceInterface alergiaService = new AlergiaServiceImp(alergiaRepository);
        AlergiaView alergiaView = new AlergiaView(alergiaService);
        AntecedenteMedicoRepositoryPort antecedenteMedicoRepository = new AntecedenteMedicoRepositoryImp();
        AntecedenteMedicoServiceInterface antecedenteMedicoService = new AntecedenteMedicoServiceImp(antecedenteMedicoRepository);
        AntecedenteMedicoView antecedenteMedicoView = new AntecedenteMedicoView(antecedenteMedicoService);
        UserInterface ui = new UserInterface(pacienteView, profesionalView, especialidadView, citaView, historiaClinicaView, consultaView, diagnosticoView, tratamientoView, medicamentoView, signoVitalView, alergiaView, antecedenteMedicoView);
        ui.menuApp();
    }
}