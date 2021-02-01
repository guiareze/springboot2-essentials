package academy.develop.springboot2essentials.service;

import academy.develop.springboot2essentials.domain.Anime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {
    //public final AnimeRepository animeRepository;
    public List<Anime> listAll() {
        return List.of(new Anime(1L, "testeZero")
                , new Anime(2L, "testeOne")
                , new Anime(3L, "testeTwo")
                , new Anime(4L, "testeThree"));
    }

}
