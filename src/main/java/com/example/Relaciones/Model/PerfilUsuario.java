package com.example.Relaciones.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
@Entity
@Table ()

public class PerfilUsuario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    @Column (nullable = false, unique = true, length = 120)
    private String documento;
    @Column (nullable = false, length = 20)
    private String telefono;




    //Optional Garantiza que todos los usuarios tengan un perfil
    @OneToOne(optional = false)
    @JoinColumn (name = "usuario_id",nullable = false,unique = true)
    @JsonIgnoreProperties ("perfil")
    private Usuario usuario;

    public PerfilUsuario() {
    }

    public PerfilUsuario(Long id, String nombre, String documento, String telefono, Usuario usuario) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.usuario = usuario;
    }

    public Long getId() {
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "PerfilUsuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", telefono='" + telefono + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
