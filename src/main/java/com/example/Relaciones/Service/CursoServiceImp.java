package com.example.Relaciones.Service;

import com.example.Relaciones.Model.Curso;
import com.example.Relaciones.Repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CursoServiceImp implements CursoService {
    private final CursoRepository cursoRepository;



    public CursoServiceImp(CursoRepository CursoRepoitory) {
        this.cursoRepository = CursoRepoitory;
    }
    @Override
    public Curso guardar(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso buscarporID(long id) {
        return cursoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }

    @Override
    public Curso buscarporNombre(String nombre) {
        return cursoRepository.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    @Override
    public Curso actualizar(long id,Curso curso) {
        Curso existente = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe"));

        existente.setNombre(curso.getNombre());
        existente.setCreditos(curso.getCreditos());

        return cursoRepository.save(existente);
    }

    @Override
    public Curso eliminar(long id) {
        Curso curso = buscarporID(id);
        cursoRepository.deleteById(id);
        return curso;
    }
}
