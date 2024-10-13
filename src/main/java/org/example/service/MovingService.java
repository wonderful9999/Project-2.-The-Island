package org.example.service;

import lombok.Getter;
import org.example.dto.location.Fields;
import org.example.dto.models.Animals.Animal;
import org.example.managers.ThreadRandomManagers;

public class MovingService {
//    @Getter
//    private static final MovingService instance = new MovingService();
    private ThreadRandomManagers threadRandomManagers;
    private DirectionService directionService;

    public MovingService() {
        directionService = new DirectionService();
        threadRandomManagers = new ThreadRandomManagers();
    }

    public void move(Animal animal, Fields fields) {
        switch (threadRandomManagers.directionRandom()) {
            case UP -> directionService.directionUp(animal, fields);
            case DOWN -> directionService.directionDown(animal, fields);
            case LEFT -> directionService.directionLeft(animal, fields);
            case RIGHT -> directionService.directionRight(animal, fields);
        }
    }
}
