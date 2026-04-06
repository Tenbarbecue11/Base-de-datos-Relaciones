package com.example.Relaciones.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categorias")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

}
