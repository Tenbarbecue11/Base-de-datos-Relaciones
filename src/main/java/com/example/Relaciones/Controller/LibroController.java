package com.example.Relaciones.Controller;

import com.example.Relaciones.Model.Libro;
import com.example.Relaciones.Service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    //Crear libro con categoria
    @PostMapping("/categoria/{categoriaId}")
    public Libro guardarLibro(@RequestBody Libro libro,
                              @PathVariable long categoriaId) {
        return libroService.guardarLibro(categoriaId,libro);
    }
    //Listar
    @GetMapping
    public List<Libro> obtenerlibros(){
        return libroService.listar();
    }
    @GetMapping("/{id}")
    public Libro obtenerLibroPorId(@PathVariable long id){
        return libroService.buscarLibroPorId(id);
    }
    @GetMapping("/titulo/{titulo}")
    public Libro obtenerLibroPorTitulo(@PathVariable String Titulo){
        return libroService.findbyTitulo(Titulo);
    }
    @GetMapping("/autor/{autor}")
    public Libro obtenerLibroPorAutor(@PathVariable String autor){
        return libroService.findbyAutor(autor);
    }
    @DeleteMapping("/{id}")
    public void EliminarCurso(@PathVariable long id){
        libroService.eliminarLibro(id);
    }
}
