package org.example.service;

import lombok.Getter;
import org.example.dto.location.Cell;
import org.example.dto.location.Fields;
import org.example.dto.models.Animals.Animal;

public class DirectionService {
    private SerchAnimalService serchAnimalService;

    public DirectionService() {
        serchAnimalService = new SerchAnimalService();
    }

    public void directionUp(Animal animal, Fields fields) {
        Cell cell = serchAnimalService.serch(animal, fields);

        if (cell.getX() - animal.getMoveCell() <= cell.getMAX_X()) {
            fields.getMapFields().get(cell).getAnimalList().remove(animal);

            Cell result = cell;
            result.setX(cell.getX() - animal.getMoveCell());

            fields.getMapFields().get(result).getAnimalList().add(animal);
        }
        else directionDown(animal, fields);
        System.out.println(animal.getName() + " переместился на " + animal.getMoveCell() + " клеток вверх");
    }

    public void directionDown(Animal animal, Fields fields) {
        Cell cell = serchAnimalService.serch(animal, fields);

        if (cell.getX() + animal.getMoveCell() <= cell.getMAX_X()) {
            fields.getMapFields().get(cell).getAnimalList().remove(animal);

            Cell result = cell;
            result.setX(cell.getX() + animal.getMoveCell());

            fields.getMapFields().get(result).getAnimalList().add(animal);
        } else directionUp(animal, fields);
        System.out.println(animal.getName() + " переместился на " + animal.getMoveCell() + " клеток вниз");
    }

    public void directionLeft(Animal animal, Fields fields) {
        Cell cell = serchAnimalService.serch(animal, fields);

        if (cell.getY() - animal.getMoveCell() <= cell.getMAX_Y()) {
            fields.getMapFields().get(cell).getAnimalList().remove(animal);

            Cell result = cell;
            result.setX(cell.getY() - animal.getMoveCell());

            fields.getMapFields().get(result).getAnimalList().add(animal);
        } else directionRight(animal, fields);
        System.out.println(animal.getName() + " переместился на " + animal.getMoveCell() + " клеток влево");
    }

    public void directionRight(Animal animal, Fields fields) {
        Cell cell = serchAnimalService.serch(animal, fields);

        if (cell.getY() + animal.getMoveCell() <= cell.getMAX_Y()) {
            fields.getMapFields().get(cell).getPlantList().remove(animal);

            Cell result = cell;
            result.setX(cell.getY() + animal.getMoveCell());

            fields.getMapFields().get(result).getAnimalList().add(animal);
        } else directionLeft(animal, fields);
        System.out.println(animal.getName() + " переместился на " + animal.getMoveCell() + " клеток вправо");
    }
}
