package com.example.Relaciones.Repository;

import com.example.Relaciones.Model.Categoria;
import com.example.Relaciones.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro,Long> {
    Optional<Libro> findByTitulo(String Titulo);
    Optional<Libro> findByAutor(String Autor);
}
