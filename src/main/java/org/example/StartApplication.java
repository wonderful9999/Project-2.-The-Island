package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto.location.Cell;
import org.example.dto.location.Fields;
import org.example.dto.models.Animals.Animal;
import org.example.managers.TaskAnimal;
import org.example.managers.TaskCreatePlant;
import org.example.service.CreateWorld;
import org.example.service.SaveService;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class StartApplication {
    CreateWorld createWorld;
    ExecutorService executorService;
    ScheduledExecutorService scheduledExecutorService;
    SaveService saveService;

    public StartApplication() throws JsonProcessingException {
        executorService = Executors.newCachedThreadPool();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        createWorld = new CreateWorld();
        saveService = new SaveService();
    }

    public void start() throws IOException {
        Fields fields = new Fields();
        createWorld.newCreateWorld(fields);


        TaskCreatePlant taskCreatePlant = new TaskCreatePlant(fields);

        for (int x = 0; x < new Cell().getMAX_X(); x++) {
            for (int y = 0; y < new Cell().getMAX_Y(); y++) {
                    for (Animal tempAnimal : fields.getMapFields().get(new Cell(x , y)).getAnimalList()) {
                        Runnable tasksAnimals = () -> {
                            new TaskAnimal(tempAnimal, fields).run();
                        };
                        executorService.submit(tasksAnimals);
                    }
            }
        }
        scheduledExecutorService.submit(taskCreatePlant);
    }
}

