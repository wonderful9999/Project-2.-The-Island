package org.example.dto.location;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor()
@NoArgsConstructor
@EqualsAndHashCode
public class Cell implements Serializable {

    @JsonProperty
    private final int MAX_Y = 50;

    @JsonProperty
    private final int MAX_X = 50;

    @JsonProperty
    private int x;

    @JsonProperty
    private int y;

}
