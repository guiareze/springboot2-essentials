package academy.develop.springboot2essentials.util;

import academy.develop.springboot2essentials.domain.Anime;
import academy.develop.springboot2essentials.requests.AnimePostRequestBody;

public class AnimePostRequestBodyCreator {

    public static AnimePostRequestBody createAnimePostRequestBody(){
        return AnimePostRequestBody.builder()
                .name(AnimeCreator.createValidAnime().getName())
                .build();
    }

}
