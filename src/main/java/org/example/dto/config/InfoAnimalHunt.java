package org.example.dto.config;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.example.dto.models.Animals.Bear;
import org.example.dto.models.Animals.Eagle;
import org.example.dto.models.Animals.Hog;
import org.example.dto.models.Animals.Wolf;

import java.util.HashMap;
import java.util.Map;

@Getter
public class InfoAnimalHunt {

    @JsonProperty
    private final Map<Integer, Integer> bear = new HashMap<>();

    {
        bear.put(new Wolf().getIdTypeAnimal(), 60);
        bear.put(new Hog().getIdTypeAnimal(), 99);
        bear.put(new Eagle().getIdTypeAnimal(), 65);
    }

    @JsonProperty
    private final Map<Integer, Integer> wolf = new HashMap<>();

    {
        wolf.put(new Bear().getIdTypeAnimal(), 30);
        wolf.put(new Hog().getIdTypeAnimal(), 95);
        wolf.put(new Eagle().getIdTypeAnimal(), 50);
    }

    @JsonProperty
    private final Map<Integer, Integer> eagle = new HashMap<>();

    {
        eagle.put(new Bear().getIdTypeAnimal(), 10);
        eagle.put(new Hog().getIdTypeAnimal(), 95);
        eagle.put(new Wolf().getIdTypeAnimal(), 40);
    }

}
