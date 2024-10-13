package org.example.service;

import lombok.Getter;
import org.example.dto.models.Animals.Animal;
import org.example.managers.ThreadRandomManagers;

public class ReproductionService {
    private ThreadRandomManagers threadRandomManagers;

    public ReproductionService() {
        threadRandomManagers = new ThreadRandomManagers();
    }

    public void reproduction(Animal animal) {
        if (animal.getQuantityRealtime() > 1 && threadRandomManagers.reproductionRandom()) {
            animal.setQuantityRealtime(animal.getQuantityRealtime() + 1);
            System.out.println(animal.getName() + " родился");
        } else System.out.println(animal.getName() + " not родился");
    }
}
