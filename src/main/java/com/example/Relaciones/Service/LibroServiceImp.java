package com.example.Relaciones.Service;

import com.example.Relaciones.Model.Categoria;
import com.example.Relaciones.Model.Libro;
import com.example.Relaciones.Repository.CategoraRepository;
import com.example.Relaciones.Repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LibroServiceImp implements LibroService {
    private final LibroRepository libroRepository;
    private final CategoraRepository categoraRepository;

    public LibroServiceImp(LibroRepository libroRepository, CategoraRepository categoraRepository) {
        this.libroRepository = libroRepository;
        this.categoraRepository = categoraRepository;
    }
    @Override
    public Libro guardarLibro(long categoriaID, Libro libro) {
        Categoria categoria = categoraRepository.findById(categoriaID).
                orElseThrow(()-> new RuntimeException("Categoria no Encontrada"));
        libro.setCategoria(categoria);

        return libroRepository.save(libro);

    }
    @Override
    public List<Libro> listar() {
        return libroRepository.findAll();
    }

    @Override
    public Libro buscarLibroPorId(long id) {
        return libroRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Libro no encontrado"));
    }

    @Override
    public Libro findbyTitulo(String Titulo) {
        return libroRepository.findByTitulo(Titulo).
                orElseThrow(()-> new RuntimeException("Libro no encontrado"));
    }

    @Override
    public Libro findbyAutor(String Autor) {
        return libroRepository.findByAutor(Autor).orElseThrow(()-> new RuntimeException("Libro no encontrado"));
    }

    @Override
    public Libro actualizar( Libro libro,long categoriaid,long libroid) {
        Libro existente =libroRepository.findById(libroid)
                .orElseThrow(() -> new RuntimeException("libro no encontrado"));
        existente.setTitulo(libro.getTitulo());
        existente.setAutor(libro.getAutor());
        existente.setYearPublication(libro.getYearPublication());
        return libroRepository.save(existente);
    }

    @Override
    public void eliminarLibro(long id) {
        Libro libro = buscarLibroPorId(id);
        libroRepository.delete(libro);
    }
}
