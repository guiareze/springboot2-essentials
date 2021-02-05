package academy.develop.springboot2essentials.repository;

import academy.develop.springboot2essentials.domain.Anime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Testes para anime repository")
class AnimeRepositoryTest {

    @Autowired
    private AnimeRepository animeRepository;

    @Test
    @DisplayName("Save creates anime when Successful")
    public void save_PersistAnime_WhenSuccessful(){
        Anime animeToBeSaved = createAnime();
        Anime animeSaved = this.animeRepository.save(animeToBeSaved);
        Assertions.assertThat(animeSaved).isNotNull();
        Assertions.assertThat(animeSaved.getId()).isNotNull();
        Assertions.assertThat(animeSaved.getName()).isEqualTo(animeToBeSaved.getName());
    }

    private Anime createAnime(){
        return Anime.builder()
                    .name("Naruto")
                    .build();
    }

}