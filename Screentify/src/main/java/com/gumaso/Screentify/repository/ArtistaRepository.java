package com.gumaso.Screentify.repository;

import com.gumaso.Screentify.models.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    @Query(value = "SELECT * FROM artista", nativeQuery = true)
    List<Artista> buscarTodosArtistas();
}
