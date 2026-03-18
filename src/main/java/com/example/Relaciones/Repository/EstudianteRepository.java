package com.example.Relaciones.Repository;

import com.example.Relaciones.Model.Categoria;
import com.example.Relaciones.Model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {
    Optional<Estudiante> findByNombre(String nombre);
}
