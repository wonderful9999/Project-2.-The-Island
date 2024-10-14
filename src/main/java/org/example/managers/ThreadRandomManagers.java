package org.example.managers;

import org.example.dto.config.SacrificaProbability;
import org.example.dto.enums.AnimalsType;
import org.example.dto.enums.Direction;
import org.example.dto.location.Fields;
import org.example.dto.models.Animals.Animal;
import org.example.service.SerchAnimalService;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadRandomManagers {

    private ThreadLocalRandom threadLocalRandom;
    private SerchAnimalService serchAnimalService;
    private SacrificaProbability sacrificaProbability;

    public ThreadRandomManagers() {
        sacrificaProbability = new SacrificaProbability();
        serchAnimalService = new SerchAnimalService();
        threadLocalRandom = ThreadLocalRandom.current();
    }

    public synchronized Direction directionRandom() {
        int randomNumber = threadLocalRandom.nextInt(4);
        return switch (randomNumber) {
            case 0 -> Direction.UP;
            case 1 -> Direction.DOWN;
            case 2 -> Direction.LEFT;
            case 3 -> Direction.RIGHT;
            default -> throw new IllegalStateException("Unexpected value: " + randomNumber);
        };
    }

    public synchronized boolean reproductionRandom() {
        return threadLocalRandom.nextInt(10) >= 4;
    }

    public synchronized Animal choosingRandomAnimalForFood(Animal animal, Fields fields) {
        List<Animal> listAnimal = fields.getMapFields().get(serchAnimalService.serch(animal, fields)).getAnimalList();
        int indexExistAnimal = listAnimal.indexOf(animal);
        int randomIndexAnimal = threadLocalRandom.nextInt(listAnimal.size());
        return indexExistAnimal == randomIndexAnimal ? choosingRandomAnimalForFood(animal, fields) : listAnimal.get(randomIndexAnimal);
    }

    public synchronized boolean hunt(Animal hunter, Animal victim) {
        int idVictim = victim.getIdTypeAnimal();
        int idHunter = hunter.getIdTypeAnimal();
        if (idHunter != idVictim) {
            int probabilitySuccess = sacrificaProbability.getMapSacrificaProbability().get(idHunter).get(idVictim);
            return threadLocalRandom.nextInt(100) < probabilitySuccess;
        }
        return false;
    }

    public synchronized AnimalsType animalsTypeRandom() {
        return AnimalsType.values()[threadLocalRandom.nextInt(AnimalsType.values().length)];
    }

}
