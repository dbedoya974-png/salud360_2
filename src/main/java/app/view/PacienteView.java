package app.view;

import app.domain.Paciente;
import app.service.inputports.PacienteServiceInterface;
import app.service.validations.FormTypeValidator;
import java.util.List;
import app.domain.enums.*;

public class PacienteView {
    private final PacienteServiceInterface service;

    public PacienteView(PacienteServiceInterface service) {
        this.service = service;
    }

    public void menu() {
        int op;
        do {
            System.out.println("\n--- GESTIÓN DE PACIENTE ---");
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
        Paciente entity = readEntity();
        if (service.findById(entity.getIdPaciente()) != null) {
            System.out.println("Ya existe un registro con ese ID.");
            return;
        }
        service.create(entity);
        System.out.println("Registro creado correctamente.");
    }

    private void list() {
        List<Paciente> list = service.selectAll();
        if (list.isEmpty()) {
            System.out.println("No hay registros.");
            return;
        }
        list.forEach(System.out::println);
    }

    private void find() {
        int id = FormTypeValidator.readInt("ID: ");
        Paciente entity = service.findById(id);
        System.out.println(entity == null ? "No encontrado." : entity);
    }

    private void update() {
        int id = FormTypeValidator.readInt("ID del registro a actualizar: ");
        if (service.findById(id) == null) {
            System.out.println("No encontrado.");
            return;
        }
        Paciente entity = readEntity();
        entity.setIdPaciente(id);
        System.out.println(service.update(entity) ? "Actualizado correctamente." : "No se pudo actualizar.");
    }

    private void delete() {
        int id = FormTypeValidator.readInt("ID: ");
        System.out.println(service.delete(id) ? "Eliminado correctamente." : "No encontrado.");
    }

    private Paciente readEntity() {
        int id=FormTypeValidator.readPositiveInt("ID paciente: ");
TipoDocumento td=FormTypeValidator.readEnum("Tipo de documento:", TipoDocumento.class);
String doc=FormTypeValidator.readString("Número de documento: ");
String nom=FormTypeValidator.readString("Nombre: ");
String ape=FormTypeValidator.readString("Apellido: ");
String fn=FormTypeValidator.readDate("Fecha de nacimiento (YYYY-MM-DD): ");
String tel=FormTypeValidator.readString("Teléfono: ");
String cor=FormTypeValidator.readEmail("Correo: ");
String dir=FormTypeValidator.readString("Dirección: ");
return new Paciente(id,td,doc,nom,ape,fn,tel,cor,dir);
    }
}
