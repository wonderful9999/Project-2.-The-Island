package org.example.dto.location;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.dto.models.Animals.Animal;
import org.example.dto.models.Plants.Plant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Creatures implements Serializable {

    @JsonProperty
    private List<Animal> animalList = new ArrayList<>();

    @JsonProperty
    private List<Plant> plantList = new ArrayList<>();
}
