package app.service.helpers;
import app.domain.enums.*;
public final class EnumHelper {
    private EnumHelper() {}
    public static TipoDocumento tipoDocumento(int option) {
        TipoDocumento[] v=TipoDocumento.values(); return v[option-1];
    }
}
