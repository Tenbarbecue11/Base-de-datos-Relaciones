package com.example.Relaciones.Service;

import com.example.Relaciones.Model.Curso;

import java.util.List;

public interface CursoService {

    Curso guardar(Curso curso);
    List<Curso> listar();
    Curso buscarporID(long id);
    Curso buscarporNombre(String nombre);
    Curso actualizar(long id,Curso curso);
    Curso eliminar(long id);

}
