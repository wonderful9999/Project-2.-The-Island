package org.example.dto.models.Animals;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Eagle extends Animal implements Serializable {
    @JsonProperty
    private final int maxQuantity = 15;

    @JsonProperty
    private final int moveCell = 10;

    @JsonProperty
    volatile private int quantityRealtime = 5;

    @JsonProperty
    private final boolean herbivore = false;

    @JsonProperty
    private final int idTypeAnimal = 103;

    @JsonProperty
    private final String name = "Орёл";

    @Override
    public boolean getHerbivore() {
        return herbivore;
    }
}
