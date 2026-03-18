package com.example.Relaciones.Repository;

import com.example.Relaciones.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoraRepository extends JpaRepository<Categoria,Long> {

    Optional<Categoria> findByNombre(String nombre);
}
