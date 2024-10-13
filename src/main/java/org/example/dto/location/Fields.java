package org.example.dto.location;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;

@Getter
@NoArgsConstructor
public class Fields implements Serializable {

    @JsonProperty
    private HashMap<Cell, Creatures> mapFields = new HashMap<>();
}
