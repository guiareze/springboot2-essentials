package academy.develop.springboot2essentials.requests;

import lombok.Data;

@Data
public class AnimePutRequestBody {
    private Long id;
    private String name;
}