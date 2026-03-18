package com.example.Relaciones.Controller;

import com.example.Relaciones.Model.Categoria;
import com.example.Relaciones.Service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    //Clear
    @PostMapping
    public Categoria guardarCategoria(@RequestBody Categoria categoria){
        return categoriaService.guardar(categoria);
    }

    //Listar
    @GetMapping
    public List<Categoria> obtenerCategorias(){
        return categoriaService.listar();
    }
    //Buscar por ID
    @GetMapping("/{id}")
    public Categoria obtenerCategoriaPorId(@PathVariable long id){
        return categoriaService.buscarPorId(id);
    }
    //Buscar por Nombre
    @GetMapping("/nombre{nombre}")
    public Categoria obtenerCategoriaPorNombre(@PathVariable String nombre){
        return categoriaService.buscarPorNombre(nombre);
    }
    //Actualizar
    @PostMapping("/{id}")
    public Categoria Actualizar(@PathVariable long id, @RequestBody Categoria categoria){
        return categoriaService.Actualizar(id,categoria);
    }
    //Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable long id){
        categoriaService.borrarPorId(id);
    }
}
