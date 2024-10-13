package org.example.managers;

import org.example.dto.location.Cell;
import org.example.dto.location.Fields;
import org.example.dto.models.Plants.Plant;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class TaskCreatePlant implements Runnable {

    private ThreadLocalRandom random = ThreadLocalRandom.current();
    private Fields fields;

    public TaskCreatePlant(Fields fields) {
        this.fields = fields;
    }

    private ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    @Override
    public void run() {
        int randomCellX = random.nextInt(50);
        int randomCellY = random.nextInt(50);
        if (fields.getMapFields().get(new Cell(randomCellX, randomCellY)).getPlantList().isEmpty()) {
            fields.getMapFields().get(new Cell(randomCellX, randomCellY)).getPlantList().add(new Plant());
            System.out.println("Растение вырасло :)");
        }
        try {
            Thread.sleep(10, TimeUnit.SECONDS.ordinal());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
