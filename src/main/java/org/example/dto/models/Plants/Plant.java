package org.example.dto.models.Plants;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Plant implements Serializable {

    @JsonProperty
    volatile private int Quantity = 30;
}
