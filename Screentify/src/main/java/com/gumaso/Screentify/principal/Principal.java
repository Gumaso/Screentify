package com.gumaso.Screentify.principal;

import com.gumaso.Screentify.models.Artista;
import com.gumaso.Screentify.models.Musica;
import com.gumaso.Screentify.models.TipoFormacao;
import com.gumaso.Screentify.repository.ArtistaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static Scanner sc = new Scanner(System.in);
    public ArtistaRepository repository;
    public Principal(ArtistaRepository artistaRepository) {
        this.repository = artistaRepository;
    }

    public void exibeMenu(){
        Artista artista1 = new Artista();
        Musica musica1 = new Musica();
        List<Musica> musicasArtista1 = new ArrayList<>();
        for (int i =0; i < 5; i++){
            System.out.println("Nome da musica: ");
            String nomeMusica= sc.nextLine();
            System.out.println("Nome do artista: ");
            String nomeArtista = sc.nextLine();
        }
        System.out.println("Nome do artista: ");
        String nomeArtista = sc.nextLine();
        System.out.println("Tipo do artista (solo, dupla, grupo): ");
        String tipo = sc.nextLine();
        var tipoDoArtista = TipoFormacao.fromString(tipo);
        artista1.setNome(nomeArtista);
        artista1.setTipo(tipoDoArtista);
        artista1.setMusicasDoArtista(musicasArtista1);
        repository.save(artista1);
    };
}
