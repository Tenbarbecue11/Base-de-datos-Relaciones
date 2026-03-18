package com.example.Relaciones.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table (name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;
    @Column (nullable = false,length = 80)
    private String nombre;
    @Column (nullable = false,unique = true,length = 120)
    private String correo;

    @OneToOne (mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnoreProperties ("ususario")
    private static PerfilUsuario perfil;

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String correo, PerfilUsuario perfil) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.perfil = perfil;
    }


    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public static PerfilUsuario getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilUsuario perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", perfil=" + perfil +
                '}';
    }
}
