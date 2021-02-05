package academy.develop.springboot2essentials.client;

import academy.develop.springboot2essentials.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {

        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/{id}", Anime.class,2);
        log.info(entity);

        Anime object = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class,5);
        log.info(object);

        Anime[] animes = new RestTemplate().getForObject("http://localhost:8080/animes/all", Anime[].class,5);
        log.info(Arrays.toString(animes));

        ResponseEntity<List<Anime>> exchange = new RestTemplate().exchange("http://localhost:8080/animes/all", HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });
        log.info(exchange.getBody());

        Anime kingdom = Anime.builder()
                            .name("KingdomThree")
                            .build();
        Anime kingdomSaved = new RestTemplate().postForObject("http://localhost:8080/animes", kingdom, Anime.class);
        log.info("saved anime {} ",kingdomSaved);

        Anime samurai = Anime.builder()
                .name("SamuraiTwo")
                .build();
        ResponseEntity<Anime> exchangeSamurai = new RestTemplate().exchange("http://localhost:8080/animes/"
                , HttpMethod.POST
                , new HttpEntity<>(samurai, createJsonHeader())
                ,Anime.class);
        log.info("saved anime {} ",exchangeSamurai);

        Anime animeToBeUpdated = exchangeSamurai.getBody();
        animeToBeUpdated.setName("Samurai Updated");
        ResponseEntity<Void> exchangeSamuraiUpdated = new RestTemplate().exchange("http://localhost:8080/animes/"
                , HttpMethod.PUT
                , new HttpEntity<>(animeToBeUpdated, createJsonHeader())
                ,Void.class);
        log.info(animeToBeUpdated);

        ResponseEntity<Void> exchangeSamuraiDelete = new RestTemplate().exchange("http://localhost:8080/animes/{id}"
                ,HttpMethod.DELETE
                ,null
                ,Void.class
                ,animeToBeUpdated.getId());


    }

    private static HttpHeaders createJsonHeader(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        //httpHeaders.setBearerAuth("asdasdasdasdasd");
        return httpHeaders;
    }

}
