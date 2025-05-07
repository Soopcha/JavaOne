package com.zoo.service;

import com.zoo.dao.AnimalDAO;
import com.zoo.model.Animal;
import java.util.List;

//Сервлеты (Controller) → AnimalService (Service) → AnimalDAO (Repository) → БД

public class AnimalService {

    private static AnimalService instance;
    private final AnimalDAO animalDAO;

    private AnimalService() {
        this.animalDAO = AnimalDAO.getInstance();
    }

    public static synchronized AnimalService getInstance() {
        if (instance == null) {
            instance = new AnimalService();
        }
        return instance;
    }

    public List<Animal> getAllAnimals() {
        return animalDAO.getAllAnimals();
    }

    public Animal getAnimalById(int id) {
        return animalDAO.getAnimalById(id);
    }

    public void createAnimal(Animal animal) {
        animalDAO.insertAnimal(animal);
    }

    public void updateAnimal(Animal animal) {
        animalDAO.updateAnimal(animal);
    }

    public void deleteAnimal(int id) {
        animalDAO.deleteAnimal(id);
    }
}
