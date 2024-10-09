package com.example.demo.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ManejadorGlobalDeErrores {

    // Maneja errores de validación, como campos vacíos o valores inválidos
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> manejarValidaciones(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();

        // Captura todos los errores de validación
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String nombreCampo = ((FieldError) error).getField();  // Obtiene el nombre del campo con error
            String mensajeError = error.getDefaultMessage();  // Obtiene el mensaje de error
            errores.put(nombreCampo, mensajeError);  // Agrega el error al mapa
        });

        // Devuelve los errores en un formato JSON con el código 400 (Bad Request)
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }

    // Maneja cualquier otro tipo de excepción general
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manejarExcepcionesGenerales(Exception ex) {
        // Devuelve un mensaje simple con el error y el estado 500 (Error interno del servidor)
        return new ResponseEntity<>("Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
