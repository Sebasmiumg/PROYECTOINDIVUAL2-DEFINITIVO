package com.example.demo.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del estudiante es obligatorio.")
    private String estudiante;

    @NotNull(message = "El puntaje de actividades es obligatorio.")
    @Max(35) @Min(0)
    private Integer actividades;

    @NotNull(message = "El puntaje del primer parcial es obligatorio.")
    @Max(15) @Min(0)
    private Integer primerParcial;

    @NotNull(message = "El puntaje del segundo parcial es obligatorio.")
    @Max(15) @Min(0)
    private Integer segundoParcial;

    @NotNull(message = "El puntaje del examen final es obligatorio.")
    @Max(35) @Min(0)
    private Integer examenFinal;

    
    private Integer puntajeTotal;

    
    public Nota() {}

    
    public Nota(String estudiante, int actividades, int primerParcial, int segundoParcial, int examenFinal) {
        this.estudiante = estudiante;
        this.actividades = actividades;
        this.primerParcial = primerParcial;
        this.segundoParcial = segundoParcial;
        this.examenFinal = examenFinal;
        this.calcularPuntajeTotal(); 
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public Integer getActividades() {
        return actividades;
    }

    public void setActividades(Integer actividades) {
        this.actividades = actividades;
    }

    public Integer getPrimerParcial() {
        return primerParcial;
    }

    public void setPrimerParcial(Integer primerParcial) {
        this.primerParcial = primerParcial;
    }

    public Integer getSegundoParcial() {
        return segundoParcial;
    }

    public void setSegundoParcial(Integer segundoParcial) {
        this.segundoParcial = segundoParcial;
    }

    public Integer getExamenFinal() {
        return examenFinal;
    }

    public void setExamenFinal(Integer examenFinal) {
        this.examenFinal = examenFinal;
    }

    public Integer getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(Integer puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }

    // Método para calcular el puntaje total
    public void calcularPuntajeTotal() {
        if (this.actividades != null && this.primerParcial != null && this.segundoParcial != null && this.examenFinal != null) {
            this.puntajeTotal = this.actividades + this.primerParcial + this.segundoParcial + this.examenFinal;
        } else {
            System.out.println("No se puede calcular el puntaje total porque uno o más valores son nulos.");
        }
    }
}
