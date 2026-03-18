package com.example.Relaciones.Controller;

import com.example.Relaciones.Model.Usuario;
import com.example.Relaciones.Service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //Clear
    @PostMapping
    public Usuario guardarUsuarios(@RequestBody Usuario usuario) {
        return usuarioService.crear(usuario);
    }
    //Listar
    @GetMapping
    public List<Usuario> obtenerUsuarios(){
        return usuarioService.listar();
    }
    //Buscar por ID
    @GetMapping("/{id}")
    public Usuario obtenerCategoriaPorId(@PathVariable long id){
        return usuarioService.buscarPorId(id);
    }
    //Actualizar
    @PostMapping("/{id}")
    public Usuario Actualizar(@PathVariable Usuario usuario){
        return usuarioService.actualizar(usuario);
    }
    //Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable long id){
        usuarioService.eliminar(id);
    }
}
