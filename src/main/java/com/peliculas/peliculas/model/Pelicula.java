package com.peliculas.peliculas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PELICULA")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pelicula_seq")
    @SequenceGenerator(name = "pelicula_seq", sequenceName = "SEQ_PELICULA", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITULO", nullable = false, length = 200)
    private String titulo;

    @Column(name = "ANO", nullable = false)
    private int ano;

    @Column(name = "DIRECTOR", length = 100)
    private String director;

    @Column(name = "GENERO", length = 50)
    private String genero;

   @Column(name = "SINOPSIS", length = 2000)
    private String sinopsis;

    public Pelicula() {
    }

    public Pelicula(Long id, String titulo, int ano, String director, String genero, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.director = director;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getSinopsis() { return sinopsis; }
    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }
}
