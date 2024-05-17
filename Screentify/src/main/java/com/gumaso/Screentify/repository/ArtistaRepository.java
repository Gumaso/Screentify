package com.gumaso.Screentify.repository;

import com.gumaso.Screentify.models.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    @Query(value = "SELECT * FROM Artista", nativeQuery = true)
    List<Artista> buscarTodosArtistas();

    @Query(value = "SELECT a FROM Artista a WHERE a.nome ILIKE %:trechoNomeArtista%")
    List<Artista> buscarNomeArtistaPorTrecho(String trechoNomeArtista);
//    @Query(value = "SELECT a FROM Artista WHERE a.nome ILIKE")
//    Optional<Artista> buscarArtistaNome();
}
