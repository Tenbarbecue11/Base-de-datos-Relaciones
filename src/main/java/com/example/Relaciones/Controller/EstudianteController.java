package com.example.Relaciones.Controller;

import com.example.Relaciones.Model.Estudiante;
import com.example.Relaciones.Service.EstudianteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public  EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }
    //Guardar
    @PostMapping
    public Estudiante guardarEstudiante(@RequestBody Estudiante estudiante){
        return estudianteService.CrearEstudiante(estudiante);
    }
    //AsignarCurso
    @PutMapping("/{id}")
    public Estudiante asignarCurso(@RequestBody long estudianteId, @RequestBody long cursoId) {
        return estudianteService.asignarCurso(estudianteId,cursoId);
    }
    //Listar
    @GetMapping
    public List<Estudiante> obtenerEstudiantes(){
        return estudianteService.findAllEstudiantes();
    }
    //Buscar por ID
    @GetMapping("/{id}")
    public Estudiante obtenerEstudiantePorId(@PathVariable long id){
        return estudianteService.findEstudianteById(id);
    }
    //Buscar Por Nombre
    @GetMapping("/nombre/{nombre}")
    public Estudiante obtenerEstudiantePorNombre(@PathVariable String nombre){
        return estudianteService.findEstudianteByNombre(nombre);
    }

    //Eliminar
    @DeleteMapping("/{id}")
    public void EliminarCurso(@PathVariable long id){
        estudianteService.deleteEstudianteById(id);
    }
}
