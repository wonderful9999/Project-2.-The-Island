package org.example.managers;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.example.dto.enums.AnimalsType;
import org.example.dto.enums.Direction;
import org.example.dto.config.SacrificaProbability;
import org.example.dto.location.Fields;
import org.example.dto.models.Animals.Animal;
import org.example.service.SerchAnimalService;

import java.io.File;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadRandomManagers {
//    @Getter
//    private static final ThreadRandomManagers instance = new ThreadRandomManagers();
    private ThreadLocalRandom threadLocalRandom;
    private SerchAnimalService serchAnimalService;
    private SacrificaProbability sacrificaProbability;

    public ThreadRandomManagers() {
        sacrificaProbability = new SacrificaProbability();
        serchAnimalService = new SerchAnimalService();
        threadLocalRandom = ThreadLocalRandom.current();
    }

    public Direction directionRandom() {
        int randomNumber = threadLocalRandom.nextInt(4);
        return switch (randomNumber) {
            case 0 -> Direction.UP;
            case 1 -> Direction.DOWN;
            case 2 -> Direction.LEFT;
            case 3 -> Direction.RIGHT;
            default -> throw new IllegalStateException("Unexpected value: " + randomNumber);
        };
    }

    public boolean reproductionRandom() {
        return threadLocalRandom.nextInt(10) >= 4;
    }

    public Animal choosingRandomAnimalForFood(Animal animal, Fields fields) {
        List<Animal> listAnimal = fields.getMapFields().get(serchAnimalService.serch(animal, fields)).getAnimalList();
        int indexExistAnimal = listAnimal.indexOf(animal);
        int randomIndexAnimal = threadLocalRandom.nextInt(listAnimal.size());
        return indexExistAnimal == randomIndexAnimal ? choosingRandomAnimalForFood(animal, fields) : listAnimal.get(randomIndexAnimal);
    }

    public boolean hunt(Animal hunter, Animal victim) {
        try {
            sacrificaProbability = new ObjectMapper(new JsonFactory()).readValue("src/main/java/org/example/config/mapSacrificalProbability.json", SacrificaProbability.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        int idVictim = victim.getIdTypeAnimal();
        int idHunter = hunter.getIdTypeAnimal();
        if (idHunter == idVictim) {
            int probabilitySuccess = sacrificaProbability.getMapSacrificaProbability().get(idHunter).get(idVictim);
            return threadLocalRandom.nextInt(100) < probabilitySuccess;
        }
        return false;
    }

    public AnimalsType animalsTypeRandom() {
        return AnimalsType.values()[threadLocalRandom.nextInt(AnimalsType.values().length)];
    }

}
