package org.example.dto.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.example.dto.models.Animals.*;

import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.put;

@Getter
public class EntityConfig {

    @JsonProperty
    private Map<Integer, Animal> animalsConfigMap = new HashMap<>(){{
        put(new Bear().getIdTypeAnimal(), new Bear());
        put(new Wolf().getIdTypeAnimal(), new Wolf());
        put(new Hog().getIdTypeAnimal(), new Hog());
        put(new Eagle().getIdTypeAnimal(), new Eagle());
    }};
}
