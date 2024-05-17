package com.gumaso.Screentify.principal;

import com.gumaso.Screentify.models.Artista;
import com.gumaso.Screentify.models.Musica;
import com.gumaso.Screentify.models.TipoFormacao;
import com.gumaso.Screentify.repository.ArtistaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class Principal {
    private Scanner sc = new Scanner(System.in);
    private ArtistaRepository repository;
    private List<Artista> artistaLista;
    public Principal(ArtistaRepository artistaRepository) {
        this.repository = artistaRepository;
    }

    public void exibeMenu() {
        artistaLista = repository.buscarTodosArtistas();
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("""
                1 - Cadastrar artistas
                2 - Cadastrar músicas
                3 - Listar músicas
                4 - Buscar músicas por artistas
                5 - Buscar artista por trecho do nome
                6 - Listar todos artistas
                0 - Sair
                """);
            var opcaoEscolha = sc.nextInt();
            sc.nextLine();
            switch (opcaoEscolha) {
                case 1:
                    cadastrandoArtistas();
                    break;
                case 2:
                    cadastrandoMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                    break;
                case 5:
                    buscarArtistaPorTrecho();
                    break;
                case 6:
                    listarArtistas();
                    break;
                case 0:
                    opcao = 0;
                    break;

            }

        }

    }
    public void cadastrandoArtistas() {
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Nome do artista: ");
        String nomeArtista = sc2.nextLine();
        System.out.println("Tipo do artista (solo, dupla, grupo): ");
        String tipo = sc2.nextLine();
        var tipoDoArtista = TipoFormacao.fromString(tipo);
        repository.save(new Artista(nomeArtista, tipoDoArtista));

    }

    public void cadastrandoMusicas() {
        Musica musica = new Musica();
        List<Musica> musicasArtista = new ArrayList<>();
        System.out.println("Nome da musica: ");
        String nomeMusica = sc.nextLine();
        System.out.println("Nome do artista: ");
        String nomeArtista = sc.nextLine();
        musicasArtista.add(new Musica());

    }

    private void listarMusicas() {

    }

    private void buscarMusicasPorArtista() {

    }

    public void buscarArtistaPorTrecho() {
        listarArtistas();
        System.out.println("Trecho do nome do artista: ");
        var nomeTrechoArtista = sc.nextLine();
        List<Artista> nomesAchados = repository.buscarNomeArtistaPorTrecho(nomeTrechoArtista);
        nomesAchados.forEach(obj  -> System.out.println(String.format("""
                Nome: %s
                """, obj.getNome())));
    }

    private void listarArtistas() {
        List<Artista> artistasListas = repository.findAll();
        System.out.println("ARTISTAS:");
        artistasListas.forEach(obj -> System.out.println(obj.getNome()));

    }


}

