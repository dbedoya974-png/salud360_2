package app.view;

import app.domain.Cita;
import app.service.inputports.CitaServiceInterface;
import app.service.validations.FormTypeValidator;
import java.util.List;
import app.domain.enums.*;

public class CitaView {
    private final CitaServiceInterface service;

    public CitaView(CitaServiceInterface service) {
        this.service = service;
    }

    public void menu() {
        int op;
        do {
            System.out.println("\n--- GESTIÓN DE CITA ---");
            System.out.println("1. Crear");
            System.out.println("2. Listar");
            System.out.println("3. Buscar por ID");
            System.out.println("4. Actualizar");
            System.out.println("5. Eliminar");
            System.out.println("0. Volver");
            op = FormTypeValidator.readInt("Opción: ");
            switch (op) {
                case 1 -> create();
                case 2 -> list();
                case 3 -> find();
                case 4 -> update();
                case 5 -> delete();
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (op != 0);
    }

    private void create() {
        Cita entity = readEntity();
        if (service.findById(entity.getIdCita()) != null) {
            System.out.println("Ya existe un registro con ese ID.");
            return;
        }
        service.create(entity);
        System.out.println("Registro creado correctamente.");
    }

    private void list() {
        List<Cita> list = service.selectAll();
        if (list.isEmpty()) {
            System.out.println("No hay registros.");
            return;
        }
        list.forEach(System.out::println);
    }

    private void find() {
        int id = FormTypeValidator.readInt("ID: ");
        Cita entity = service.findById(id);
        System.out.println(entity == null ? "No encontrado." : entity);
    }

    private void update() {
        int id = FormTypeValidator.readInt("ID del registro a actualizar: ");
        if (service.findById(id) == null) {
            System.out.println("No encontrado.");
            return;
        }
        Cita entity = readEntity();
        entity.setIdCita(id);
        System.out.println(service.update(entity) ? "Actualizado correctamente." : "No se pudo actualizar.");
    }

    private void delete() {
        int id = FormTypeValidator.readInt("ID: ");
        System.out.println(service.delete(id) ? "Eliminado correctamente." : "No encontrado.");
    }

    private Cita readEntity() {
        int id=FormTypeValidator.readInt("ID cita: ");
String f=FormTypeValidator.readString("Fecha (YYYY-MM-DD): ");
String h=FormTypeValidator.readString("Hora (HH:MM): ");
String m=FormTypeValidator.readString("Motivo: ");
EstadoCita e=FormTypeValidator.readEnum("Estado:", EstadoCita.class);
int p=FormTypeValidator.readInt("ID paciente: ");
int pr=FormTypeValidator.readInt("ID profesional: ");
return new Cita(id,f,h,m,e,p,pr);
    }
}
