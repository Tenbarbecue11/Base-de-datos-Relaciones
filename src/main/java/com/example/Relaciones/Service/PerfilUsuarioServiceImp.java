package com.example.Relaciones.Service;

import com.example.Relaciones.Model.PerfilUsuario;
import com.example.Relaciones.Repository.PerfilUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PerfilUsuarioServiceImp implements  PerfilUsuarioService {
    private final PerfilUsuarioRepository perfilUsuarioRepository;

    public  PerfilUsuarioServiceImp(PerfilUsuarioRepository perfilUsuarioRepository) {
        this.perfilUsuarioRepository = perfilUsuarioRepository;
    }
    @Override
    public PerfilUsuario guardar(PerfilUsuario perfilUsuario) {
        return perfilUsuarioRepository.save(perfilUsuario);
    }
    @Override
    public PerfilUsuario obtener(long Id) {
        return  perfilUsuarioRepository.findById(Id).
                orElseThrow(()-> new RuntimeException("No existe el perfil usuario con el id: " + Id));
    }

    @Override
    public List<PerfilUsuario> listar() {
        return perfilUsuarioRepository.findAll();
    }

    @Override
    public PerfilUsuario actualizar(long id, PerfilUsuario perfilUsuario) {
        PerfilUsuario existente=perfilUsuarioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No existe el perfil usuario con el id: " + id));
        existente.setNombre(perfilUsuario.getNombre());
        existente.setDocumento(perfilUsuario.getDocumento());
        existente.setTelefono(perfilUsuario.getTelefono());
        existente.setUsuario(perfilUsuario.getUsuario());
        return perfilUsuarioRepository.save(existente);
    }

    @Override
    public void eliminar(long id) {
        PerfilUsuario perfilUsuario=obtener(id);
        perfilUsuarioRepository.delete(perfilUsuario);
    }
}
