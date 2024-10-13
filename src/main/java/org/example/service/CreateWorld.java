package org.example.service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.example.dto.location.Cell;
import org.example.dto.location.Creatures;
import org.example.dto.location.Fields;
import org.example.dto.models.Plants.Plant;
import org.example.managers.Factory;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class CreateWorld {
    private ThreadLocalRandom threadLocalRandom;
    private Factory factory;

    public CreateWorld() throws JsonProcessingException {
        threadLocalRandom = ThreadLocalRandom.current();
        factory = new Factory();
    }
    public void newCreateWorld(Fields fields) {
        for (int x = 0; x < new Cell().getMAX_X(); x++) {
            for (int y = 0; y < new Cell().getMAX_Y(); y++) {
                fields.getMapFields().put(new Cell(x, y), new Creatures(new ArrayList<>(), new ArrayList<>()));
                for (int i = 0; i < 5; i++) {
                    if (threadLocalRandom.nextInt(100) < 30) {
                        fields.getMapFields().get(new Cell(x, y)).getAnimalList().add(factory.factoryAnimalsRandom());
                        fields.getMapFields().get(new Cell(x, y)).getPlantList().add(new Plant());
                    }
                }
            }
        }
    }

    public Fields createSaveWorld() throws JsonProcessingException {
        return new ObjectMapper(new JsonFactory()).readValue("src/main/java/org/example/config/island.json", Fields.class);
    }


}
