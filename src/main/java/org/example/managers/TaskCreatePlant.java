package org.example.managers;

import org.example.dto.location.Cell;
import org.example.dto.location.Fields;
import org.example.dto.models.Plants.Plant;

import java.util.concurrent.ThreadLocalRandom;

public class TaskCreatePlant implements Runnable {

    private ThreadLocalRandom random = ThreadLocalRandom.current();
    private Fields fields;

    public TaskCreatePlant(Fields fields) {
        this.fields = fields;
    }

    @Override
    public synchronized void run() {
        int randomCellX = random.nextInt(50);
        int randomCellY = random.nextInt(50);
        if (fields.getMapFields().get(new Cell(randomCellX, randomCellY)).getPlantList().isEmpty()) {
            fields.getMapFields().get(new Cell(randomCellX, randomCellY)).getPlantList().add(new Plant());
            System.out.println("Растение вырасло :)");
        }
        try {
            Thread.currentThread().sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
