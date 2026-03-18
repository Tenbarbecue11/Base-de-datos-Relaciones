package com.example.Relaciones.Service;

import com.example.Relaciones.Model.Usuario;

import com.example.Relaciones.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioServiceImp implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImp(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public Usuario buscarPorId(long id) {
        return usuarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public Usuario crear(Usuario usuario) {
        if(Usuario.getPerfil()!=null){
            Usuario.getPerfil().setUsuario(usuario);
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizar(Usuario usuario) {
        Usuario existente =buscarPorId(usuario.getId());
        existente.setNombre(usuario.getNombre());
        return usuarioRepository.save(existente);

    }

    @Override
    public void eliminar(long id) {
        Usuario usuario = buscarPorId(id);
        usuarioRepository.delete(usuario);

    }

    @Override
    public List<Usuario> listar() {

        return usuarioRepository.findAll();
    }
}
