package app.view;

import app.domain.HistoriaClinica;
import app.service.inputports.HistoriaClinicaServiceInterface;
import app.service.validations.FormTypeValidator;
import java.util.List;

public class HistoriaClinicaView {
    private final HistoriaClinicaServiceInterface service;

    public HistoriaClinicaView(HistoriaClinicaServiceInterface service) {
        this.service = service;
    }

    public void menu() {
        int op;
        do {
            System.out.println("\n--- GESTIÓN DE HISTORIACLINICA ---");
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
        HistoriaClinica entity = readEntity();
        if (service.findById(entity.getIdHistoria()) != null) {
            System.out.println("Ya existe un registro con ese ID.");
            return;
        }
        service.create(entity);
        System.out.println("Registro creado correctamente.");
    }

    private void list() {
        List<HistoriaClinica> list = service.selectAll();
        if (list.isEmpty()) {
            System.out.println("No hay registros.");
            return;
        }
        list.forEach(System.out::println);
    }

    private void find() {
        int id = FormTypeValidator.readInt("ID: ");
        HistoriaClinica entity = service.findById(id);
        System.out.println(entity == null ? "No encontrado." : entity);
    }

    private void update() {
        int id = FormTypeValidator.readInt("ID del registro a actualizar: ");
        if (service.findById(id) == null) {
            System.out.println("No encontrado.");
            return;
        }
        HistoriaClinica entity = readEntity();
        entity.setIdHistoria(id);
        System.out.println(service.update(entity) ? "Actualizado correctamente." : "No se pudo actualizar.");
    }

    private void delete() {
        int id = FormTypeValidator.readInt("ID: ");
        System.out.println(service.delete(id) ? "Eliminado correctamente." : "No encontrado.");
    }

    private HistoriaClinica readEntity() {
        int id=FormTypeValidator.readInt("ID historia: ");
String f=FormTypeValidator.readString("Fecha de apertura (YYYY-MM-DD): ");
String o=FormTypeValidator.readString("Observaciones: ");
int p=FormTypeValidator.readInt("ID paciente: ");
return new HistoriaClinica(id,f,o,p);
    }
}
