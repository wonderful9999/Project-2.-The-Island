package org.example.managers;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.config.EntityConfig;
import org.example.dto.enums.AnimalsType;
import org.example.dto.models.Animals.*;

public class Factory {
//    @Getter
//    private static final Factory instance;

//    static {
//        try {
//            instance = new Factory();
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//    }

    private ThreadRandomManagers threadRandomManagers;

    private EntityConfig entityConfig = new EntityConfig();

    public Factory() throws JsonProcessingException {
        threadRandomManagers = new ThreadRandomManagers();
        entityConfig = new EntityConfig(); /*new ObjectMapper(new JsonFactory()).readValue("src/main/java/org/example/config/entity.json", EntityConfig.class)*/
    }

    public Animal factoryAnimalsRandom() {
//        try {
//            entityConfig = new ObjectMapper(new JsonFactory()).readValue("src//main//java//org//example//config//entity.json", EntityConfig.class);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }

        return switch (threadRandomManagers.animalsTypeRandom()) {
            case HOG -> entityConfig.getAnimalsConfigMap().get(new Hog().getIdTypeAnimal());
            case BEAR -> entityConfig.getAnimalsConfigMap().get(new Bear().getIdTypeAnimal());
            case WOLF -> entityConfig.getAnimalsConfigMap().get(new Wolf().getIdTypeAnimal());
            case EAGLE -> entityConfig.getAnimalsConfigMap().get(new Eagle().getIdTypeAnimal());
        };
    }

    public Animal factoryAnimals(AnimalsType animalsType) {
//        try {
//            entityConfig = new ObjectMapper(new JsonFactory()).readValue("src//main//java//org//example//config//entity.json", EntityConfig.class);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }

        return switch (animalsType) {
            case HOG -> entityConfig.getAnimalsConfigMap().get(new Hog().getIdTypeAnimal());
            case BEAR -> entityConfig.getAnimalsConfigMap().get(new Bear().getIdTypeAnimal());
            case WOLF -> entityConfig.getAnimalsConfigMap().get(new Wolf().getIdTypeAnimal());
            case EAGLE -> entityConfig.getAnimalsConfigMap().get(new Eagle().getIdTypeAnimal());
        };
    }
}
