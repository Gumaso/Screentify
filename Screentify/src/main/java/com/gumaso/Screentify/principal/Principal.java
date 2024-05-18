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
        var condicao = "S";
        while (condicao.equalsIgnoreCase("S")) {
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Nome do artista: ");
            String nomeArtista = sc2.nextLine();
            System.out.println("Tipo do artista (solo, dupla, grupo): ");
            String tipo = sc2.nextLine();
            var tipoDoArtista = TipoFormacao.fromString(tipo);
            repository.save(new Artista(nomeArtista, tipoDoArtista));
            condicao = continuarFuncao();
        }

    }
    public String continuarFuncao() {
        System.out.println("Continuar? S/N");
        var escolhaOpcao = sc.nextLine();
        return escolhaOpcao.toUpperCase();
    }

    public void cadastrandoMusicas() {
        System.out.println("Escolha o artista para adicionar músicas!!!".toUpperCase());
        listarArtistas();
        buscarArtistaPorTrecho();
        System.out.println("Escolha pelo número do ID: ");
        var idArtista = sc.nextLong();
        sc.nextLine();
        Optional<Artista> artistaOptional = repository.findById(idArtista);
        if (artistaOptional.isPresent()){
            List<Musica> musicasArtista = new ArrayList<>();

            while (true){
                System.out.println("Nome da musica: ");
                String nomeMusica = sc.nextLine();
                musicasArtista.add(new Musica(nomeMusica, artistaOptional.get()) );
                musicasArtista.stream().forEach(obj -> artistaOptional.get().getMusicasDoArtista().add(obj));
                System.out.println("Cadastrar mais músicas: (S/N)");
                var continuarSimNao = sc.nextLine();
                if (continuarSimNao.equalsIgnoreCase("n")){
                    repository.save(artistaOptional.get());
                    break;
                }

            }


        }else{
            System.out.println("Artista não encontrado!");
        }



    }

    private void listarMusicas() {
        List<Artista> musicaList = repository.findAll();
        var musicas = musicaList.stream().map(obj -> obj.getMusicasDoArtista()).toList();
        for (var musica:musicas){
            if (musica.isEmpty()){
            }else{
                musica.forEach(obj -> System.out.println( obj.getNome()));

            }
        }
    }

    private void buscarMusicasPorArtista() {
        buscarArtistaPorTrecho();
        System.out.println("Escolha pelo número do ID: ");
        var idArtista = sc.nextLong();
        sc.nextLine();
        Optional<Artista> artistaOptional = repository.findById(idArtista);
        if (artistaOptional.isPresent()){
            artistaOptional.get().getMusicasDoArtista().forEach(obj -> System.out.println(obj.getNome()));
        }else{
            System.out.println("Artista não encontrado ");
        }
    }

    public void buscarArtistaPorTrecho() {
        listarArtistas();
        System.out.println("Trecho do nome do artista: ");
        var nomeTrechoArtista = sc.nextLine();
        List<Artista> nomesAchados = repository.buscarNomeArtistaPorTrecho(nomeTrechoArtista);
        nomesAchados.forEach(obj  -> System.out.println("ID: "+ obj.getId()+ " Nome: " +  obj.getNome()));
    }

    private void listarArtistas() {
        List<Artista> artistasListas = repository.findAll();
        System.out.println("ARTISTAS:");
        artistasListas.forEach(obj -> System.out.println(obj.getNome()));

    }


}

