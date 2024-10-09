package com.example.demo.controladores;

import com.example.demo.modelos.Nota;
import com.example.demo.repositorios.NotaRepositorio;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notas")
public class NotaControlador {

    private final NotaRepositorio notaRepositorio;

    public NotaControlador(NotaRepositorio notaRepositorio) {
        this.notaRepositorio = notaRepositorio;
    }

    @GetMapping
    public List<Nota> obtenerNotas() {
        return notaRepositorio.findAll();
    }

    @PostMapping
    public ResponseEntity<Nota> registrarNota(@RequestBody @Valid Nota nota) {
        // Imprimir los datos recibidos desde el frontend para depuración
        System.out.println("Estudiante recibido: " + nota.getEstudiante());
        System.out.println("Actividades recibidas: " + nota.getActividades());
        System.out.println("Primer Parcial recibido: " + nota.getPrimerParcial());
        System.out.println("Segundo Parcial recibido: " + nota.getSegundoParcial());
        System.out.println("Examen Final recibido: " + nota.getExamenFinal());

        // Calcular el puntaje total directamente en el backend
        nota.calcularPuntajeTotal();

        // Guardar la nueva nota en la base de datos
        Nota nuevaNota = notaRepositorio.save(nota);

        // Imprimir la nota guardada para confirmar
        System.out.println("Nota guardada: " + nuevaNota.toString());

        return new ResponseEntity<>(nuevaNota, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> obtenerNotaPorId(@PathVariable Long id) {
        Optional<Nota> notaOptional = notaRepositorio.findById(id);
        if (notaOptional.isPresent()) {
            return ResponseEntity.ok(notaOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nota> actualizarNota(@PathVariable Long id, @RequestBody @Valid Nota notaActualizada) {
        Optional<Nota> notaOptional = notaRepositorio.findById(id);
        if (notaOptional.isPresent()) {
            Nota nota = notaOptional.get();
            nota.setActividades(notaActualizada.getActividades());
            nota.setPrimerParcial(notaActualizada.getPrimerParcial());
            nota.setSegundoParcial(notaActualizada.getSegundoParcial());
            nota.setExamenFinal(notaActualizada.getExamenFinal());
            nota.calcularPuntajeTotal();
            notaRepositorio.save(nota);
            return ResponseEntity.ok(nota);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNota(@PathVariable Long id) {
        if (notaRepositorio.existsById(id)) {
            notaRepositorio.deleteById(id);
            System.out.println("Nota con ID: " + id + " eliminada");
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
