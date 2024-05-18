package com.gumaso.Screentify.models;

import jakarta.persistence.*;

@Entity
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    public Musica(String nome, Artista artista) {
        this.nome = nome;
        this.artista = artista;

    }

    public Musica() {
    }



    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "artista=" + artista.getNome() +
                ", nome='" + nome + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }
}
