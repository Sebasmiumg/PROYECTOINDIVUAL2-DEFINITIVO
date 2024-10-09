-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS nueva_base_notas;

-- Usar la nueva base de datos
USE nueva_base_notas;

-- Eliminar la tabla 'notas' si ya existe para reiniciar la estructura
DROP TABLE IF EXISTS notas;

-- Crear la tabla 'notas' con las restricciones y el cálculo de puntaje
CREATE TABLE notas (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- ID único y autoincremental
  estudiante VARCHAR(100) NOT NULL,  -- Nombre del estudiante
  actividades INT CHECK(actividades >= 0 AND actividades <= 35),  -- Validación para el puntaje de actividades
  primerParcial INT CHECK(primerParcial >= 0 AND primerParcial <= 15),  -- Validación para el primer parcial
  segundoParcial INT CHECK(segundoParcial >= 0 AND segundoParcial <= 15),  -- Validación para el segundo parcial
  examenFinal INT CHECK(examenFinal >= 0 AND examenFinal <= 35),  -- Validación para el examen final
  puntajeTotal INT  -- Puntaje total calculado en el backend y almacenado
);

-- Consulta para ver los registros almacenados en la tabla 'notas'
SELECT * FROM notas;
