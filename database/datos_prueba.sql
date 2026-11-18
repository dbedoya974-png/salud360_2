-- SALUD 360 - DATOS FICTICIOS PARA PRUEBAS ACADEMICAS
-- ADVERTENCIA: Todos los registros de este archivo son inventados.
-- No representan pacientes, profesionales ni historias clinicas reales.
-- Ejecutar DESPUES de importar salud360.sql. Se usan identificadores 900xxx.
USE salud360;

INSERT IGNORE INTO pacientes
(id_paciente, tipo_documento, numero_documento, nombre, apellido, fecha_nacimiento, telefono, correo, direccion)
VALUES
(900001, 'CC', 'TEST-PAC-900001', 'Paciente', 'Prueba Uno', '1995-05-15', '0000000000', 'paciente.prueba1@example.test', 'Direccion ficticia - uso academico');

INSERT IGNORE INTO especialidades (id_especialidad, nombre, descripcion)
VALUES (900001, 'Especialidad de prueba', 'Registro ficticio para validar el modulo de especialidades');

INSERT IGNORE INTO profesionales
(id_profesional, tipo_documento, numero_documento, nombre, apellido, telefono, correo, registro_profesional, id_especialidad)
VALUES
(900001, 'CC', 'TEST-PRO-900001', 'Profesional', 'Demostracion', '0000000000', 'profesional.prueba@example.test', 'TEST-REG-900001', 900001);

INSERT IGNORE INTO historias_clinicas (id_historia, fecha_apertura, observaciones, id_paciente)
VALUES (900001, '2026-01-01', 'Historia ficticia. No contiene informacion medica real.', 900001);

INSERT IGNORE INTO citas (id_cita, fecha, hora, motivo, estado, id_paciente, id_profesional)
VALUES (900001, '2026-01-15', '09:00:00', 'Cita de demostracion academica', 'PROGRAMADA', 900001, 900001);

INSERT IGNORE INTO consultas (id_consulta, fecha, motivo, observaciones, id_cita, id_historia)
VALUES (900001, '2026-01-15', 'Consulta de prueba', 'Registro ficticio para probar relaciones entre tablas.', 900001, 900001);

INSERT IGNORE INTO diagnosticos (id_diagnostico, descripcion, fecha, id_consulta)
VALUES (900001, 'Diagnostico de demostracion sin valor clinico.', '2026-01-15', 900001);

INSERT IGNORE INTO tratamientos (id_tratamiento, descripcion, fecha_inicio, fecha_fin, indicaciones, id_consulta)
VALUES (900001, 'Tratamiento ficticio de prueba', '2026-01-15', '2026-01-20', 'No seguir. Dato inventado para pruebas de software.', 900001);

INSERT IGNORE INTO medicamentos (id_medicamento, nombre, descripcion, presentacion)
VALUES (900001, 'Medicamento de prueba', 'Elemento ficticio; no corresponde a un producto real.', 'Presentacion de demostracion');

INSERT IGNORE INTO signos_vitales
(id_signo_vital, fecha, temperatura, presion_arterial, frecuencia_cardiaca, frecuencia_respiratoria, peso, talla, id_consulta)
VALUES (900001, '2026-01-15', 0.00, 'NO APLICA - DATO FICTICIO', 0, 0, 0.00, 0.00, 900001);

INSERT IGNORE INTO alergias (id_alergia, descripcion, tipo, id_paciente)
VALUES (900001, 'Alergia de prueba: no corresponde a una persona real ni debe usarse para decisiones medicas.', 'OTRA', 900001);

INSERT IGNORE INTO antecedentes_medicos (id_antecedente, descripcion, fecha, tipo, id_paciente)
VALUES (900001, 'Antecedente ficticio para verificar el modulo. Sin valor clinico.', '2026-01-15', 'OTRO', 900001);
