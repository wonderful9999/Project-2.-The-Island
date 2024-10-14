package org.example.managers;

import org.example.dto.location.Fields;
import org.example.dto.models.Animals.Animal;
import org.example.service.EatingService;
import org.example.service.MovingService;
import org.example.service.ReproductionService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TaskAnimal implements Runnable {
    private MovingService movingService = new MovingService();
    private ReproductionService reproductionService = new ReproductionService();
    private EatingService eatingService = new EatingService();

    private ExecutorService executorService = Executors.newCachedThreadPool();

    private Animal animal;
    private Fields fields;

    public TaskAnimal(Animal animal, Fields fields) {
        this.animal = animal;
        this.fields = fields;
    }

    @Override
    public synchronized void run() {
        movingService.move(animal, fields);
        reproductionService.reproduction(animal);
        for (int i = 0; i < 5; i++) {
            eatingService.eat(animal, fields);
        }
        try {
            Thread.currentThread().sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
