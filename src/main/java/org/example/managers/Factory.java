package org.example.managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto.config.EntityConfig;
import org.example.dto.enums.AnimalsType;
import org.example.dto.models.Animals.*;

public class Factory {


    private ThreadRandomManagers threadRandomManagers;

    private EntityConfig entityConfig;

    public Factory() throws JsonProcessingException {
        threadRandomManagers = new ThreadRandomManagers();
        entityConfig = new EntityConfig();
    }

    public synchronized Animal factoryAnimalsRandom() {
        return switch (threadRandomManagers.animalsTypeRandom()) {
            case HOG -> entityConfig.getAnimalsConfigMap().get(new Hog().getIdTypeAnimal());
            case BEAR -> entityConfig.getAnimalsConfigMap().get(new Bear().getIdTypeAnimal());
            case WOLF -> entityConfig.getAnimalsConfigMap().get(new Wolf().getIdTypeAnimal());
            case EAGLE -> entityConfig.getAnimalsConfigMap().get(new Eagle().getIdTypeAnimal());
        };
    }

    public synchronized Animal factoryAnimals(AnimalsType animalsType) {
        return switch (animalsType) {
            case HOG -> entityConfig.getAnimalsConfigMap().get(new Hog().getIdTypeAnimal());
            case BEAR -> entityConfig.getAnimalsConfigMap().get(new Bear().getIdTypeAnimal());
            case WOLF -> entityConfig.getAnimalsConfigMap().get(new Wolf().getIdTypeAnimal());
            case EAGLE -> entityConfig.getAnimalsConfigMap().get(new Eagle().getIdTypeAnimal());
        };
    }
}
