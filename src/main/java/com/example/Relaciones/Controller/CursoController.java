package com.example.Relaciones.Controller;

import com.example.Relaciones.Model.Curso;
import com.example.Relaciones.Service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }
    @PutMapping("/{id}")
    public Curso guardar(@RequestBody Curso curso, @PathVariable long id){
        return cursoService.actualizar(id, curso);
    }
    //Guardar
    @PostMapping
    public Curso guardarCurso(@RequestBody Curso curso){
        return cursoService.guardar(curso);
    }
    //Listar
    @GetMapping
    public List<Curso> obtenerCurso(){
        return cursoService.listar();
    }
    @GetMapping("/{id}")
    public Curso obtenerCursoPorId(@PathVariable long id){
        return cursoService.buscarporID(id);
    }
    @GetMapping("/nombre/{nombre}")
    public Curso obtenerCursoPorNombre(@PathVariable String nombre){
        return cursoService.buscarporNombre(nombre);
    }
    @DeleteMapping("/{id}")
    public void EliminarCurso(@PathVariable long id){
        cursoService.eliminar(id);
    }
}
