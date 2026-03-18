package com.example.Relaciones.Service;

import com.example.Relaciones.Model.Estudiante;

import java.util.List;

public interface EstudianteService {

    Estudiante asignarCurso(long id, long cursoId);
    Estudiante CrearEstudiante(Estudiante estudiante);
    Estudiante findEstudianteById(Long id);
    Estudiante findEstudianteByNombre(String nombre);
    List<Estudiante> findAllEstudiantes();
    void deleteEstudianteById(Long id);

}
