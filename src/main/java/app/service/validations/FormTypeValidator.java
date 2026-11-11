package app.service.validations;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;
public final class FormTypeValidator {
    private static final Scanner SCANNER = new Scanner(System.in);
    private FormTypeValidator() {}
    public static String readString(String message) {
        while (true) {
            System.out.print(message);
            String value = SCANNER.nextLine().trim();
            if (!value.isEmpty()) return value;
            System.out.println("El campo no puede estar vacío.");
        }
    }
    public static int readInt(String message) {
        while (true) {
            try { return Integer.parseInt(readString(message)); }
            catch (NumberFormatException e) { System.out.println("Ingrese un número entero válido."); }
        }
    }
    public static int readPositiveInt(String message) {
        while (true) {
            int value = readInt(message);
            if (value > 0) return value;
            System.out.println("El valor debe ser mayor que cero.");
        }
    }
    public static String readEmail(String message) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
        while (true) {
            String value = readString(message);
            if (pattern.matcher(value).matches()) return value;
            System.out.println("Ingrese un correo válido (ejemplo@dominio.com).");
        }
    }
    public static String readDate(String message) {
        while (true) {
            String value = readString(message);
            try {
                LocalDate date = LocalDate.parse(value);
                if (!date.isAfter(LocalDate.now())) return value;
                System.out.println("La fecha no puede ser futura.");
            } catch (DateTimeParseException e) {
                System.out.println("Use el formato YYYY-MM-DD y una fecha válida.");
            }
        }
    }
    public static double readDouble(String message) {
        while (true) {
            try { return Double.parseDouble(readString(message).replace(",", ".")); }
            catch (NumberFormatException e) { System.out.println("Ingrese un número válido."); }
        }
    }
    public static <E extends Enum<E>> E readEnum(String message, Class<E> enumClass) {
        E[] values = enumClass.getEnumConstants();
        while (true) {
            System.out.println(message);
            for (int i=0;i<values.length;i++) System.out.println((i+1)+". "+values[i]);
            int option = readInt("Seleccione una opción: ");
            if (option >= 1 && option <= values.length) return values[option-1];
            System.out.println("Opción inválida.");
        }
    }
}
