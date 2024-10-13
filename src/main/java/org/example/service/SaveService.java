package org.example.service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.example.dto.config.EntityConfig;
import org.example.dto.config.InfoAnimalHunt;
import org.example.dto.config.SacrificaProbability;
import org.example.dto.location.Fields;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class SaveService {
//    @Getter
//    private static final SaveService instance = new SaveService();
//
//    private SaveService() {
//    }

    public void save(Fields fields) throws IOException {
        new ObjectMapper(new JsonFactory()).writeValue(new File("src/main/java/org/example/config/save/world.json"), fields);
    }

    public void saveNewConfig(Map<Integer, Map<Integer, Integer>> sacrificaProbability) throws IOException {
        new ObjectMapper(new JsonFactory()).writeValue(new File("src/main/java/org/example/config/mapSacrificalProbability.json"), sacrificaProbability);
    }

    public void saveNewConfig(EntityConfig entityConfig) throws IOException {
        new ObjectMapper(new JsonFactory()).writeValue(new File("src/main/java/org/example/config/entity.json"), entityConfig);
    }

    public void saveNewConfig(InfoAnimalHunt infoAnimalHunt) throws IOException {
        new ObjectMapper(new JsonFactory()).writeValue(new File("src/main/java/org/example/config/infoAnimalHunt.json"), infoAnimalHunt);
    }

}
