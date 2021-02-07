package academy.develop.springboot2essentials.util;

import academy.develop.springboot2essentials.domain.Anime;
import academy.develop.springboot2essentials.requests.AnimePostRequestBody;
import academy.develop.springboot2essentials.requests.AnimePutRequestBody;

public class AnimePutRequestBodyCreator {

    public static AnimePutRequestBody createAnimePutRequestBody(){
        return AnimePutRequestBody.builder()
                .id(AnimeCreator.createValidUpdatedAnime().getId())
                .name(AnimeCreator.createValidUpdatedAnime().getName())
                .build();
    }

}
