package academy.develop.springboot2essentials.service;

import academy.develop.springboot2essentials.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AnimeService {

    private static List<Anime> animes;
    static{
        animes = new ArrayList<>(List.of(new Anime(1L, "testeZero")
                , new Anime(2L, "testeOne")
                , new Anime(3L, "testeTwo")
                , new Anime(4L, "testeThree")));
    }

    //public final AnimeRepository animeRepository;
    public List<Anime> listAll() {
        return animes;
    }

    public Anime findById(long id) {
        return animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Anime not found"));
    }

    public Anime save(Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextLong(5,1000000));
        animes.add(anime);
        return anime;
    }
}
