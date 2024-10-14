package org.example.service;

import org.example.dto.location.Fields;
import org.example.dto.models.Animals.Animal;
import org.example.managers.ThreadRandomManagers;

public class MovingService {
    private ThreadRandomManagers threadRandomManagers;
    private DirectionService directionService;

    public MovingService() {
        directionService = new DirectionService();
        threadRandomManagers = new ThreadRandomManagers();
    }

    public synchronized void move(Animal animal, Fields fields) {
        switch (threadRandomManagers.directionRandom()) {
            case UP -> directionService.directionUp(animal, fields);
            case DOWN -> directionService.directionDown(animal, fields);
            case LEFT -> directionService.directionLeft(animal, fields);
            case RIGHT -> directionService.directionRight(animal, fields);
        }
    }
}
