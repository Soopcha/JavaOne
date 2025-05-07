package com.zoo;


import com.zoo.dao.AnimalDAO;
import com.zoo.db.DatabaseConnection;
import com.zoo.model.Animal;
import com.zoo.service.AnimalService;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection.getConnection();

        AnimalService animalService = AnimalService.getInstance();

        // Добавляем животных через сервис
        animalService.createAnimal(new Animal(0, "Лев", "Потомок льва", 5, "Савана", "Здоров"));
        animalService.createAnimal(new Animal(0, "Тигр", "Амурский тигр", 3, "Лес", "Здоров"));

        // Получаем животных через сервис
        System.out.println("Все животные:");
        animalService.getAllAnimals().forEach(System.out::println);

        // Пример работы с конкретным животным
        int animalId = 1;
        Animal animal = animalService.getAnimalById(animalId);
        if (animal != null) {
            System.out.println("Животное с ID " + animalId + ": " + animal);

            // Обновление через сервис
            animal.setHealthStatus("Болезненно");
            animalService.updateAnimal(animal);
            System.out.println("После обновления: " + animalService.getAnimalById(animalId));
        }


//        // Удаляем животное
//        int animalIdToDelete = 2; // животное с id 2
//        animalDAO.deleteAnimal(animalIdToDelete);
//        System.out.println("Животное с ID " + animalIdToDelete + " было удалено.");

    }
}
