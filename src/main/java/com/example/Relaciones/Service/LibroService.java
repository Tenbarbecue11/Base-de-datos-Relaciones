package com.example.Relaciones.Service;

import com.example.Relaciones.Model.Categoria;
import com.example.Relaciones.Model.Libro;

import java.util.List;

public interface LibroService {
    Libro guardarLibro(long id, Libro libro);
    List<Libro> listar();
    Libro buscarLibroPorId(long id);
    Libro findbyTitulo(String Titulo);
    Libro findbyAutor(String Autor);
    Libro  actualizar( Libro libro,long categoriaid,long libroid);
    void  eliminarLibro(long id);

}
