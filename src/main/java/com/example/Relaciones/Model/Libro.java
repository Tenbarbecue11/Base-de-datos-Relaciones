package com.example.Relaciones.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table (name = "libro")

public class Libro {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, length = 120)
    private String titulo;

    @Column (nullable = false, length = 120)
    private String autor;

    @Column (name = "Year_Publication", nullable = false)
    private int yearPublication;

    //Optional - Libros Siempre Deben tener una categoria
    //

    @ManyToOne (optional = false, fetch = FetchType.EAGER)
    @JoinColumn (name = "Categoria_id", nullable = false)
    @JsonBackReference
    private Categoria Categoria;

    public Libro() {
    }

    public Libro(Long id, String titulo, String autor, int yearPublication) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.yearPublication = yearPublication;
    }

    public Categoria getCategoria() {
        return Categoria;
    }

    public void setCategoria(Categoria categoria) {
        Categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", yearPublication=" + yearPublication +
                '}';
    }
}
