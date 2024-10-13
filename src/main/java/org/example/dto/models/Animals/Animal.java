package org.example.dto.models.Animals;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Animal {

    @JsonProperty
    private final int maxQuantity = 0;

    @JsonProperty
    private final int moveCell = 0;

    @JsonProperty
    private int quantityRealtime = 0;

    @JsonProperty
    private final boolean herbivore = false;

    @JsonProperty
    private final int idTypeAnimal = 0;

    @JsonProperty
    private String name = "";

    public boolean getHerbivore() {
        return herbivore;
    }
}
