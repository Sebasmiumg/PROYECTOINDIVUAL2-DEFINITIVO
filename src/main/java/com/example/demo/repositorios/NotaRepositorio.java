package com.example.demo.repositorios;

import com.example.demo.modelos.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepositorio extends JpaRepository<Nota, Long> {
}
