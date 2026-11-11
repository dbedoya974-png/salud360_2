-- Salud360 - Esquema relacional para MariaDB / XAMPP
-- Importar desde phpMyAdmin (http://localhost/phpmyadmin) o ejecutar en MariaDB.
CREATE DATABASE IF NOT EXISTS salud360
  CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE salud360;

CREATE TABLE IF NOT EXISTS pacientes (
  id_paciente INT PRIMARY KEY,
  tipo_documento VARCHAR(20) NOT NULL,
  numero_documento VARCHAR(30) NOT NULL UNIQUE,
  nombre VARCHAR(100) NOT NULL,
  apellido VARCHAR(100) NOT NULL,
  fecha_nacimiento DATE NOT NULL,
  telefono VARCHAR(30) NOT NULL,
  correo VARCHAR(150) NOT NULL,
  direccion VARCHAR(250) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS especialidades (
  id_especialidad INT PRIMARY KEY,
  nombre VARCHAR(120) NOT NULL UNIQUE,
  descripcion VARCHAR(500)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS profesionales (
  id_profesional INT PRIMARY KEY,
  tipo_documento VARCHAR(20) NOT NULL,
  numero_documento VARCHAR(30) NOT NULL UNIQUE,
  nombre VARCHAR(100) NOT NULL,
  apellido VARCHAR(100) NOT NULL,
  telefono VARCHAR(30) NOT NULL,
  correo VARCHAR(150) NOT NULL,
  registro_profesional VARCHAR(80) NOT NULL UNIQUE,
  id_especialidad INT NOT NULL,
  CONSTRAINT fk_profesional_especialidad FOREIGN KEY (id_especialidad)
    REFERENCES especialidades(id_especialidad)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS historias_clinicas (
  id_historia INT PRIMARY KEY,
  fecha_apertura DATE NOT NULL,
  observaciones TEXT,
  id_paciente INT NOT NULL UNIQUE,
  CONSTRAINT fk_historia_paciente FOREIGN KEY (id_paciente)
    REFERENCES pacientes(id_paciente)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS citas (
  id_cita INT PRIMARY KEY,
  fecha DATE NOT NULL,
  hora TIME NOT NULL,
  motivo VARCHAR(500) NOT NULL,
  estado VARCHAR(20) NOT NULL,
  id_paciente INT NOT NULL,
  id_profesional INT NOT NULL,
  CONSTRAINT fk_cita_paciente FOREIGN KEY (id_paciente)
    REFERENCES pacientes(id_paciente),
  CONSTRAINT fk_cita_profesional FOREIGN KEY (id_profesional)
    REFERENCES profesionales(id_profesional)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS consultas (
  id_consulta INT PRIMARY KEY,
  fecha DATE NOT NULL,
  motivo VARCHAR(500) NOT NULL,
  observaciones TEXT,
  id_cita INT NOT NULL,
  id_historia INT NOT NULL,
  CONSTRAINT fk_consulta_cita FOREIGN KEY (id_cita)
    REFERENCES citas(id_cita),
  CONSTRAINT fk_consulta_historia FOREIGN KEY (id_historia)
    REFERENCES historias_clinicas(id_historia)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS diagnosticos (
  id_diagnostico INT PRIMARY KEY,
  descripcion TEXT NOT NULL,
  fecha DATE NOT NULL,
  id_consulta INT NOT NULL,
  CONSTRAINT fk_diagnostico_consulta FOREIGN KEY (id_consulta)
    REFERENCES consultas(id_consulta)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS tratamientos (
  id_tratamiento INT PRIMARY KEY,
  descripcion TEXT NOT NULL,
  fecha_inicio DATE NOT NULL,
  fecha_fin DATE,
  indicaciones TEXT,
  id_consulta INT NOT NULL,
  CONSTRAINT fk_tratamiento_consulta FOREIGN KEY (id_consulta)
    REFERENCES consultas(id_consulta)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS medicamentos (
  id_medicamento INT PRIMARY KEY,
  nombre VARCHAR(150) NOT NULL,
  descripcion TEXT,
  presentacion VARCHAR(120) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS signos_vitales (
  id_signo_vital INT PRIMARY KEY,
  fecha DATE NOT NULL,
  temperatura DECIMAL(5,2) NOT NULL,
  presion_arterial VARCHAR(30) NOT NULL,
  frecuencia_cardiaca INT NOT NULL,
  frecuencia_respiratoria INT NOT NULL,
  peso DECIMAL(6,2) NOT NULL,
  talla DECIMAL(5,2) NOT NULL,
  id_consulta INT NOT NULL,
  CONSTRAINT fk_signo_consulta FOREIGN KEY (id_consulta)
    REFERENCES consultas(id_consulta)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS alergias (
  id_alergia INT PRIMARY KEY,
  descripcion VARCHAR(500) NOT NULL,
  tipo VARCHAR(30) NOT NULL,
  id_paciente INT NOT NULL,
  CONSTRAINT fk_alergia_paciente FOREIGN KEY (id_paciente)
    REFERENCES pacientes(id_paciente)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS antecedentes_medicos (
  id_antecedente INT PRIMARY KEY,
  descripcion TEXT NOT NULL,
  fecha DATE NOT NULL,
  tipo VARCHAR(30) NOT NULL,
  id_paciente INT NOT NULL,
  CONSTRAINT fk_antecedente_paciente FOREIGN KEY (id_paciente)
    REFERENCES pacientes(id_paciente)
) ENGINE=InnoDB;
