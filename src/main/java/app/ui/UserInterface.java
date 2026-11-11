package app.ui;

import app.service.validations.FormTypeValidator;
import app.view.*;

public class UserInterface {
    private final PacienteView pacienteView;
    private final ProfesionalView profesionalView;
    private final EspecialidadView especialidadView;
    private final CitaView citaView;
    private final HistoriaClinicaView historiaView;
    private final ConsultaView consultaView;
    private final DiagnosticoView diagnosticoView;
    private final TratamientoView tratamientoView;
    private final MedicamentoView medicamentoView;
    private final SignoVitalView signoVitalView;
    private final AlergiaView alergiaView;
    private final AntecedenteMedicoView antecedenteView;

    public UserInterface(PacienteView pacienteView, ProfesionalView profesionalView, EspecialidadView especialidadView,
                         CitaView citaView, HistoriaClinicaView historiaView, ConsultaView consultaView,
                         DiagnosticoView diagnosticoView, TratamientoView tratamientoView, MedicamentoView medicamentoView,
                         SignoVitalView signoVitalView, AlergiaView alergiaView, AntecedenteMedicoView antecedenteView) {
        this.pacienteView=pacienteView; this.profesionalView=profesionalView; this.especialidadView=especialidadView;
        this.citaView=citaView; this.historiaView=historiaView; this.consultaView=consultaView;
        this.diagnosticoView=diagnosticoView; this.tratamientoView=tratamientoView; this.medicamentoView=medicamentoView;
        this.signoVitalView=signoVitalView; this.antecedenteView=antecedenteView; this.alergiaView=alergiaView;
    }

    public void menuApp() {
        int op;
        do {
            System.out.println("\n========================================");
            System.out.println("          SALUD360 - SISTEMA INTEGRAL");
            System.out.println("========================================");
            System.out.println("1. Pacientes");
            System.out.println("2. Profesionales");
            System.out.println("3. Especialidades");
            System.out.println("4. Citas");
            System.out.println("5. Historias clínicas");
            System.out.println("6. Consultas");
            System.out.println("7. Diagnósticos");
            System.out.println("8. Tratamientos");
            System.out.println("9. Medicamentos");
            System.out.println("10. Signos vitales");
            System.out.println("11. Alergias");
            System.out.println("12. Antecedentes médicos");
            System.out.println("0. Salir");
            op=FormTypeValidator.readInt("Seleccione: ");
            switch(op) {
                case 1 -> pacienteView.menu();
                case 2 -> profesionalView.menu();
                case 3 -> especialidadView.menu();
                case 4 -> citaView.menu();
                case 5 -> historiaView.menu();
                case 6 -> consultaView.menu();
                case 7 -> diagnosticoView.menu();
                case 8 -> tratamientoView.menu();
                case 9 -> medicamentoView.menu();
                case 10 -> signoVitalView.menu();
                case 11 -> alergiaView.menu();
                case 12 -> antecedenteView.menu();
                case 0 -> System.out.println("Gracias por usar Salud360.");
                default -> System.out.println("Opción inválida.");
            }
        } while(op!=0);
    }
}
