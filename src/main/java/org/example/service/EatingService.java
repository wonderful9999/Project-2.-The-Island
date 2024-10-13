package org.example.service;

import lombok.Getter;
import org.example.dto.location.Fields;
import org.example.dto.models.Animals.Animal;
import org.example.dto.models.Plants.Plant;
import org.example.managers.ThreadRandomManagers;

public class EatingService {
//    @Getter
//    private static final EatingService instance = new EatingService();

    private SerchAnimalService serchAnimalService;
    private ThreadRandomManagers threadRandomManagers;
    private DeleteService deleteService;

    public EatingService() {
        deleteService = new DeleteService();
        threadRandomManagers = new ThreadRandomManagers();
        serchAnimalService = new SerchAnimalService();
    }

    public void eat(Animal animal, Fields fields) {
        if (animal.getHerbivore()) {
            eatPlant(animal, fields);
        } else eatMeat(animal, fields);
    }

    private void eatPlant(Animal animal, Fields fields) {
        Plant result = fields.getMapFields().get(serchAnimalService.serch(animal, fields)).getPlantList().get(0);

        if (result.getQuantity() - 1 == 0) {
            fields.getMapFields().get(serchAnimalService.serch(animal, fields)).getPlantList().remove(result);
            System.out.println(animal.getName() + " поел растение");
        } else result.setQuantity(result.getQuantity() - 1);

    }

    private void eatMeat(Animal hunter, Fields fields) {
        Animal victim = threadRandomManagers.choosingRandomAnimalForFood(hunter, fields);
        if (threadRandomManagers.hunt(hunter, victim)) {
            if (victim.getQuantityRealtime() - 1 == 0) {
                deleteService.deleteAnimal(victim, fields);
            }
            else victim.setQuantityRealtime(victim.getQuantityRealtime() - 1);
            System.out.println(hunter.getName() + " съел " + victim.getName());
        }
        System.out.println(hunter.getName() + " не смог съесть " + victim.getName());
    }

}
