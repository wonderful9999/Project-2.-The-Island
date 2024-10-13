package org.example.dto.models.Animals;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Hog extends Animal implements Serializable {

    @JsonProperty
    private final int maxQuantity = 25;

    @JsonProperty
    private final int moveCell = 7;

    @JsonProperty
    private int quantityRealtime = 5;

    @JsonProperty
    private final boolean herbivore = true;

    @JsonProperty
    private final int idTypeAnimal = 201;

    @JsonProperty
    private String name = "Кабан";

    @Override
    public boolean getHerbivore() {
        return super.getHerbivore();
    }
}
