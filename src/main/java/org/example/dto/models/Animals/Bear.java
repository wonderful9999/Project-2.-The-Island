package org.example.dto.models.Animals;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

import static org.example.dto.enums.AnimalsType.BEAR;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Bear extends Animal implements Serializable {

    @JsonProperty
    private final int maxQuantity = 35;

    @JsonProperty
    private final int moveCell = 6;

    @JsonProperty
    private int quantityRealtime = 5;

    @JsonProperty
    private final boolean herbivore = false;

    @JsonProperty
    private final int idTypeAnimal = 101;

    @JsonProperty
    private String name = "Медведь";

    @Override
    public boolean getHerbivore() {
        return super.getHerbivore();
    }
}
