package com.example.Relaciones.Service;

import com.example.Relaciones.Model.Curso;
import com.example.Relaciones.Model.Estudiante;
import com.example.Relaciones.Repository.CursoRepository;
import com.example.Relaciones.Repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudiantesServiceImp implements EstudianteService{
    private final EstudianteRepository estudianteRepository;
    private final CursoRepository cursoRepository;
    public EstudiantesServiceImp(EstudianteRepository estudianteRepository, CursoRepository cursoRepository) {
        this.estudianteRepository = estudianteRepository;
        this.cursoRepository = cursoRepository;
    }
    @Override
    public Estudiante asignarCurso(long estudianteId, long cursoId){

        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow();

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow();

        estudiante.getCursos().add(curso);

        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante CrearEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante findEstudianteById(long id) {
        return estudianteRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    @Override
    public Estudiante findEstudianteByNombre(String nombre) {
        return estudianteRepository.findByNombre(nombre)
                .orElseThrow(()-> new RuntimeException("Estudiante no encontrado"));
    }


    @Override
    public List<Estudiante> findAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
    public void deleteEstudianteById(long id) {
        Estudiante estudiante = findEstudianteById(id);
        estudianteRepository.deleteById(id);
    }
}
