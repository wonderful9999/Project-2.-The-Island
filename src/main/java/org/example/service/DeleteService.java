package org.example.service;

import lombok.Getter;
import org.example.dto.location.Fields;
import org.example.dto.models.Animals.Animal;

public class DeleteService {
//    @Getter
//    private static final DeleteService instance = new DeleteService();
    private SerchAnimalService serchAnimalService;

    public DeleteService() {
        serchAnimalService = new SerchAnimalService();
    }

    public void deleteAnimal(Animal animal, Fields fields) {
        fields.getMapFields().get(serchAnimalService.serch(animal, fields)).getAnimalList().remove(animal);
    }
}
