package academy.develop.springboot2essentials.repository;

import academy.develop.springboot2essentials.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();
}
