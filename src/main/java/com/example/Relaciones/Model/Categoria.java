package com.example.Relaciones.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categorias")

public class Categoria {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false,unique = true,length = 88)
    private String nombre;
    @Column (nullable = false, length = 150)
    private String description;



    @OneToMany (mappedBy = "Categoria", cascade = CascadeType.ALL,orphanRemoval = false)
    @JsonManagedReference
    private  List<Libro> libro = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(Long id, String nombre, String description) {
        this.id = id;
        this.nombre = nombre;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
