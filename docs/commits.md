# Historial de commits incluido en esta entrega

El repositorio Git local conserva el historial completo de trabajo. Los commits principales son:

| Commit | Tipo | Descripción |
|---|---|---|
| `c62af10` | feat | Estructura inicial por capas y módulos CRUD |
| `53f059f` | docs | Documentar arquitectura y alcance del sistema |
| `38f7c54` | docs | Agregar historias de usuario y criterios de aceptación |
| `ec14dc0` | docs | Anexar informe PDF e historial de commits |
| `1a95259` | docs | Completar historial en anexo PDF |
| `dbbfaf6` | docs | Actualizar PDF con historial Git completo |
| `d1c2d28` | docs | Registrar historial Git final en documentación |
| `8d2a42d` | feat | Integrar persistencia MariaDB con JDBC en los 12 módulos |

La integración con MariaDB reemplaza los repositorios temporales basados en `ArrayList` por repositorios JDBC. El script `database/salud360.sql` crea las 12 tablas y sus relaciones.

Para consultar el historial íntegro y actualizado, ejecutar `git log --oneline` desde la carpeta `Salud360`.

**Importante:** los commits están incluidos en el repositorio Git local del ZIP. No se afirma que estén publicados en GitHub. Para publicarlos, agregar el repositorio remoto y ejecutar `git push -u origin master` (o la rama principal que corresponda).
