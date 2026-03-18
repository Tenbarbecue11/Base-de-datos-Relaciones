package com.example.Relaciones.Repository;

import com.example.Relaciones.Model.Categoria;
import com.example.Relaciones.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByNombre(String nombre);
}
