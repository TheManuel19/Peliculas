package com.edu.mx.pelicula.model.bean;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class BeanPelicula {
    private Integer id;
    private String titulo;
    private String categoria;
    private String descripcion;
    private java.sql.Date fechaEstreno;
    private String duracion;
    private String autor;

    public BeanPelicula() {
    }

    public BeanPelicula(Integer id, String titulo, String categoria, String descripcion, java.sql.Date fechaEstreno, String duracion, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.fechaEstreno = fechaEstreno;
        this.duracion = duracion;
        this.autor = autor;
    }

    public BeanPelicula(String titulo, String categoria, String descripcion, java.sql.Date fechaEstreno, String  duracion, String autor) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.fechaEstreno = fechaEstreno;
        this.duracion = duracion;
        this.autor = autor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(java.sql.Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
