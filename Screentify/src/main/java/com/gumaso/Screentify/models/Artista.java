package com.gumaso.Screentify.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    @OneToMany(mappedBy = "artista",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Musica> musicasDoArtista = new ArrayList<>();
    public Artista() {
    }

    @Enumerated(EnumType.STRING)
    private TipoFormacao tipo;
    public TipoFormacao getTipo() {
        return tipo;
    }

    public Artista(String nome, TipoFormacao tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return String.format("""
                Informações do artista:
                Nome: %s
                Tipo de formação: %s
                Quantidade de músicas: %s 
                
                """, nome, tipo, musicasDoArtista.size());
    }
    public void setTipo(TipoFormacao tipo) {
        this.tipo = tipo;
    }

    public List<Musica> getMusicasDoArtista() {
        return musicasDoArtista;
    }

    public void setMusicasDoArtista(List<Musica> musicasDoArtista) {
        this.musicasDoArtista = musicasDoArtista;
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

    public void setId(Long id) {
        this.id = id;
    }
}
