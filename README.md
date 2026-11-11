# Salud360 — Sistema integral de gestión de salud

Aplicación académica de consola desarrollada en Java 17+, organizada por capas y con almacenamiento temporal en memoria. Permite administrar información clínica y operativa básica de una institución de salud.

## Funcionalidades

- Gestión CRUD de pacientes, profesionales y especialidades.
- Gestión de citas e historias clínicas.
- Registro de consultas, diagnósticos y tratamientos.
- Administración de medicamentos, signos vitales, alergias y antecedentes médicos.
- Menús por módulo y validación de entradas.
- Separación de responsabilidades mediante `domain`, `view`, `service`, `repository` y `ui`.
- Puertos de entrada/salida e inyección de dependencias por constructor.

## Requisitos

- JDK 17 o superior.
- Apache Maven 3.8 o superior (recomendado).

## Ejecución

Desde la carpeta `Salud360`:

```bash
mvn clean compile
mvn exec:java
```

También puede abrirse como proyecto Maven en IntelliJ IDEA y ejecutar `app.Application`.

## Estructura

```text
src/main/java/app/
├── domain/                 # Entidades y enumeraciones
├── repository/             # Implementaciones de almacenamiento
├── service/                # Casos de uso y validaciones
│   ├── inputports/         # Contratos de servicios
│   └── outputports/        # Contratos de repositorios
├── view/                   # Interacción de cada módulo
├── ui/                     # Menú principal
└── Application.java        # Punto de entrada
```

## Validaciones destacadas

- Los campos de texto obligatorios no aceptan valores vacíos.
- Los identificadores de pacientes deben ser positivos.
- El correo del paciente debe tener una estructura válida.
- La fecha de nacimiento debe existir, respetar `YYYY-MM-DD` y no ser futura.
- Los datos se vuelven a solicitar cuando no cumplen las reglas.

## Alcance y limitaciones conocidas

Esta versión guarda los datos en colecciones `ArrayList`: la información se pierde al cerrar la aplicación. No es una historia clínica electrónica lista para producción, no tiene autenticación, autorización por roles, cifrado, auditoría ni persistencia en una base de datos. Para un despliegue real se requiere implementar esos controles y cumplir la normativa aplicable de protección de datos personales y datos sensibles.

La entrega recibida contiene una interfaz de consola (CLI), no una interfaz web/gráfica (front-end). Por ello, el anexo no presenta capturas de un front inexistente; se deja indicado en el informe.

## Documentación

- `docs/historias_usuario_y_aceptacion.md`: historias de usuario y criterios verificables.
- `docs/modelo_salud360.md`: entidades y relaciones del modelo.
- `docs/commits.md`: historial de cambios incorporado a esta entrega.
- `docs/entrega_proyecto.pdf`: anexo solicitado para la entrega.

## Repositorio

Enlace GitHub: **PENDIENTE DE COMPLETAR**. El ZIP incluye el historial Git local; después de crear el repositorio remoto, publicar la rama principal y reemplazar este texto por su URL.

## Integrantes

Los nombres no venían incluidos en el ZIP recibido. Completar los nombres reales en `docs/entrega_proyecto.pdf` y en el apartado de integrantes antes de entregar.
