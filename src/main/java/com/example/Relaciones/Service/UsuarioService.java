package com.example.Relaciones.Service;

import com.example.Relaciones.Model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario buscarPorId(long id);
    Usuario crear(Usuario usuario);
    Usuario actualizar(Usuario usuario);
    void eliminar(long id);
    List<Usuario> listar();

}
