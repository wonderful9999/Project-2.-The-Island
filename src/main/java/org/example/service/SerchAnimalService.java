package org.example.service;

import lombok.Getter;
import org.example.dto.location.Cell;
import org.example.dto.location.Creatures;
import org.example.dto.location.Fields;
import org.example.dto.models.Animals.Animal;

import java.util.Map;

public class SerchAnimalService {
//    @Getter
//    private static final SerchAnimalService instance = new SerchAnimalService();

//    private SerchAnimalService() {
//    }

    public Cell serch(Animal animal, Fields fields) {
        try {
            for (Map.Entry<Cell, Creatures> entry : fields.getMapFields().entrySet()) {
                if (entry.getValue().getAnimalList().contains(animal)) {
                    return entry.getKey();
                }
            }
        } catch (Exception e) {
            throw new NullPointerException();
        }
        return null;
    }
}

