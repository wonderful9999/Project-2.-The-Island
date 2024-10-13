package org.example.dto.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.example.dto.models.Animals.Bear;
import org.example.dto.models.Animals.Eagle;
import org.example.dto.models.Animals.Wolf;

import java.util.HashMap;
import java.util.Map;

@Getter
public class SacrificaProbability {

    private InfoAnimalHunt infoAnimalHunt = new InfoAnimalHunt();

    @JsonProperty
    private Map<Integer, Map<Integer, Integer>> mapSacrificaProbability = new HashMap<>();

    {
        mapSacrificaProbability.put(new Bear().getIdTypeAnimal(), infoAnimalHunt.getBear());
        mapSacrificaProbability.put(new Wolf().getIdTypeAnimal(), infoAnimalHunt.getWolf());
        mapSacrificaProbability.put(new Eagle().getIdTypeAnimal(), infoAnimalHunt.getEagle());
    }
}
