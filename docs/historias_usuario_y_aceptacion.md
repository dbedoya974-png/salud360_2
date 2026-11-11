# Historias de usuario y criterios mínimos de aceptación — Salud360

## HU-01. Registrar paciente
**Como** personal administrativo, **quiero** registrar un paciente, **para** mantener sus datos básicos disponibles en el sistema.

Criterios de aceptación:
1. El sistema solicita identificación, nombre, apellido, fecha de nacimiento, teléfono, correo y dirección.
2. No permite continuar con campos obligatorios vacíos.
3. El identificador debe ser un entero positivo y no debe estar repetido.
4. La fecha debe ser válida, usar `YYYY-MM-DD` y no ser posterior al día actual.
5. El correo debe tener una estructura válida.
6. Si los datos cumplen las reglas, confirma la creación y el paciente aparece al listar.

## HU-02. Consultar pacientes
**Como** usuario del sistema, **quiero** listar y buscar pacientes por ID, **para** consultar sus datos registrados.

Criterios de aceptación:
1. La opción listar muestra todos los pacientes registrados en la sesión.
2. Si no existen registros, informa que la lista está vacía.
3. La búsqueda devuelve el paciente cuando el ID existe.
4. Si el ID no existe, muestra un mensaje de no encontrado sin cerrar la aplicación.

## HU-03. Actualizar datos de paciente
**Como** personal autorizado, **quiero** actualizar los datos de un paciente, **para** mantener su información al día.

Criterios de aceptación:
1. Solicita el ID del registro a modificar.
2. Si el ID no existe, informa que no fue encontrado.
3. Si existe, solicita los nuevos datos y conserva el ID original.
4. Al guardar, confirma la actualización y el listado refleja los cambios.

## HU-04. Eliminar paciente
**Como** personal autorizado, **quiero** eliminar un registro de paciente, **para** corregir registros creados por error.

Criterios de aceptación:
1. Solicita el ID del registro.
2. Si existe, lo elimina y confirma la operación.
3. Si no existe, informa que no fue encontrado.

## HU-05. Administrar profesionales y especialidades
**Como** personal administrativo, **quiero** registrar y consultar profesionales y especialidades, **para** organizar la oferta de atención.

Criterios de aceptación:
1. El menú principal permite acceder a los módulos de profesionales y especialidades.
2. Cada módulo ofrece las operaciones CRUD implementadas.
3. Los datos creados se pueden consultar durante la sesión.

## HU-06. Gestionar citas
**Como** personal de recepción, **quiero** gestionar citas, **para** organizar la atención entre pacientes y profesionales.

Criterios de aceptación:
1. El menú principal permite entrar al módulo de citas.
2. El módulo permite ejecutar las operaciones CRUD disponibles.
3. El sistema informa el resultado de cada operación.

## HU-07. Consultar historia clínica y consultas
**Como** profesional de salud, **quiero** registrar y consultar historias clínicas y consultas, **para** disponer de un historial organizado de atención.

Criterios de aceptación:
1. Se puede acceder a los módulos de historia clínica y consulta desde el menú principal.
2. Se pueden crear, listar, buscar, actualizar y eliminar registros según las opciones implementadas.
3. Los resultados de las operaciones se informan claramente.

## HU-08. Registrar información clínica complementaria
**Como** profesional de salud, **quiero** administrar diagnósticos, tratamientos, medicamentos, signos vitales, alergias y antecedentes, **para** complementar la información de atención.

Criterios de aceptación:
1. Cada módulo está disponible desde el menú principal.
2. Los módulos permiten las operaciones CRUD implementadas.
3. Los datos permanecen disponibles mientras la aplicación siga ejecutándose.

## Nota de alcance

Las historias describen el comportamiento de la versión académica de consola. La persistencia actual es temporal y no reemplaza un sistema clínico productivo. Los criterios de HU-05 a HU-08 deben verificarse módulo por módulo durante la demostración.
