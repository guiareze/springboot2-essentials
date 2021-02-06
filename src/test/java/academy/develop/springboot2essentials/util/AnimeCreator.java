package academy.develop.springboot2essentials.util;

import academy.develop.springboot2essentials.domain.Anime;

public class AnimeCreator {

    public static Anime createAnimeToBeSaved(){
        return Anime.builder()
                .name("Naruto")
                .build();
    }

    public static Anime createValidAnime(){
        return Anime.builder()
                .name("Naruto")
                .id(1L)
                .build();
    }

    public static Anime createValidUpdatedAnime(){
        return Anime.builder()
                .name("Sara")
                .id(1L)
                .build();
    }

}
