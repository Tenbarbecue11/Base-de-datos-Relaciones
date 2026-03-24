package com.example.Relaciones.Service;

import com.example.Relaciones.Model.Categoria;
import com.example.Relaciones.Repository.CategoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiseImp implements CategoriaService {

    private final CategoraRepository categoriaRepository;

    public CategoriaServiseImp(CategoraRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria buscarPorId(long id) {
        return categoriaRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }

    @Override
    public Categoria buscarPorNombre(String nombre) {
        return categoriaRepository.findByNombre(nombre)
                .orElseThrow(()-> new RuntimeException("Categoria no encontrada"));
    }

    @Override
    public Categoria Actualizar(long id, Categoria categoria) {
        Categoria existente =categoriaRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        existente.setNombre(categoria.getNombre());
        existente.setDescription(categoria.getDescription());
        return categoriaRepository.save(existente);
    }

    @Override
    public void borrarPorId(long id) {
        categoriaRepository.deleteById(id);
        categoriaRepository.deleteById(id);
    }
}
