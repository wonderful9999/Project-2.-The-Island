package org.example.service;

import org.example.dto.location.Fields;
import org.example.dto.models.Animals.Animal;

public class DeleteService {
    private SerchAnimalService serchAnimalService;

    public DeleteService() {
        serchAnimalService = new SerchAnimalService();
    }

    public synchronized void deleteAnimal(Animal animal, Fields fields) {
        fields.getMapFields().get(serchAnimalService.serch(animal, fields)).getAnimalList().remove(animal);
    }
}
