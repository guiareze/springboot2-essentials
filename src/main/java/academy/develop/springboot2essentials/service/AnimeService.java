package academy.develop.springboot2essentials.service;

import academy.develop.springboot2essentials.domain.Anime;
import academy.develop.springboot2essentials.exception.BadRequestException;
import academy.develop.springboot2essentials.mapper.AnimeMapper;
import academy.develop.springboot2essentials.repository.AnimeRepository;
import academy.develop.springboot2essentials.requests.AnimePostRequestBody;
import academy.develop.springboot2essentials.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    public final AnimeRepository animeRepository;

    public Page<Anime> listAll(Pageable pageable) {
        return animeRepository.findAll(pageable);
    }

    public List<Anime> listAllNonPageable() { return animeRepository.findAll(); }

    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public Anime findById(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime not found")) ;
            //.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Anime not found"));
    }

    @Transactional
    public Anime save(AnimePostRequestBody animePostRequestBody) {
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    public void delete(long id) {
        animeRepository.delete(findById(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findById(animePutRequestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);
    }

}
