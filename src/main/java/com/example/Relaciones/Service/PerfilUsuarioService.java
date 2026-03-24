package com.example.Relaciones.Service;

import com.example.Relaciones.Model.PerfilUsuario;

import java.util.List;

public interface PerfilUsuarioService {
    PerfilUsuario guardar(PerfilUsuario perfilUsuario);
    PerfilUsuario obtener(long id);
    List<PerfilUsuario> listar();
    PerfilUsuario actualizar(long id, PerfilUsuario perfilUsuario);
    void eliminar(long id);
}
