package com.example.Relaciones.Controller;

import com.example.Relaciones.Model.PerfilUsuario;
import com.example.Relaciones.Service.PerfilUsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilUsuarioController {
    private final PerfilUsuarioService perfilUsuarioService;
    public PerfilUsuarioController(PerfilUsuarioService perfilUsuarioService) {
        this.perfilUsuarioService = perfilUsuarioService;
    }

    //Crear
    @PostMapping
    public PerfilUsuario guardar(@RequestBody PerfilUsuario  perfilUsuario) {
        return perfilUsuarioService.guardar(perfilUsuario);
    }
    @GetMapping
    public List<PerfilUsuario> listar() {
        return perfilUsuarioService.listar();
    }
    @GetMapping ("/{id}")
    public PerfilUsuario buscar(@PathVariable long id) {
        return perfilUsuarioService.obtener(id);
    }
    @PutMapping ("/{id}")
    public PerfilUsuario actualizar(@PathVariable long id, @RequestBody PerfilUsuario perfilUsuario) {
        return perfilUsuarioService.actualizar(id, perfilUsuario);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable long id) {
        perfilUsuarioService.eliminar(id);
    }
}