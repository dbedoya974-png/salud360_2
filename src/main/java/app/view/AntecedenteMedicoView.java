package app.view;

import app.domain.AntecedenteMedico;
import app.service.inputports.AntecedenteMedicoServiceInterface;
import app.service.validations.FormTypeValidator;
import java.util.List;
import app.domain.enums.*;

public class AntecedenteMedicoView {
    private final AntecedenteMedicoServiceInterface service;

    public AntecedenteMedicoView(AntecedenteMedicoServiceInterface service) {
        this.service = service;
    }

    public void menu() {
        int op;
        do {
            System.out.println("\n--- GESTIÓN DE ANTECEDENTEMEDICO ---");
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
        AntecedenteMedico entity = readEntity();
        if (service.findById(entity.getIdAntecedente()) != null) {
            System.out.println("Ya existe un registro con ese ID.");
            return;
        }
        service.create(entity);
        System.out.println("Registro creado correctamente.");
    }

    private void list() {
        List<AntecedenteMedico> list = service.selectAll();
        if (list.isEmpty()) {
            System.out.println("No hay registros.");
            return;
        }
        list.forEach(System.out::println);
    }

    private void find() {
        int id = FormTypeValidator.readInt("ID: ");
        AntecedenteMedico entity = service.findById(id);
        System.out.println(entity == null ? "No encontrado." : entity);
    }

    private void update() {
        int id = FormTypeValidator.readInt("ID del registro a actualizar: ");
        if (service.findById(id) == null) {
            System.out.println("No encontrado.");
            return;
        }
        AntecedenteMedico entity = readEntity();
        entity.setIdAntecedente(id);
        System.out.println(service.update(entity) ? "Actualizado correctamente." : "No se pudo actualizar.");
    }

    private void delete() {
        int id = FormTypeValidator.readInt("ID: ");
        System.out.println(service.delete(id) ? "Eliminado correctamente." : "No encontrado.");
    }

    private AntecedenteMedico readEntity() {
        int id=FormTypeValidator.readInt("ID antecedente: ");
String d=FormTypeValidator.readString("Descripción: ");
String f=FormTypeValidator.readString("Fecha (YYYY-MM-DD): ");
TipoAntecedente t=FormTypeValidator.readEnum("Tipo:", TipoAntecedente.class);
int p=FormTypeValidator.readInt("ID paciente: ");
return new AntecedenteMedico(id,d,f,t,p);
    }
}
