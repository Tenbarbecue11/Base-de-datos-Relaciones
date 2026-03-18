package com.example.Relaciones.Service;

import com.example.Relaciones.Model.Categoria;

import java.util.List;

public interface CategoriaService {

    Categoria guardar(Categoria categoria);
    List<Categoria> listar();
    Categoria buscarPorId(long id);
    Categoria buscarPorNombre(String nombre);
    Categoria Actualizar(long id, Categoria categoria);
    void borrarPorId(long id);
}
