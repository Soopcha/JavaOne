package com.zoo;


import com.zoo.dao.AnimalDAO;
import com.zoo.db.DatabaseConnection;
import com.zoo.model.Animal;

public class Main {
    public static void main(String[] args) {
        // Устанавливаем соединение с базой данных
        DatabaseConnection.getConnection();

        // Добавляем несколько животных
        AnimalDAO animalDAO = new AnimalDAO();
        animalDAO.addAnimal(new Animal("Лев", "Потомок льва", 5, "Савана", "Здоров"));
        animalDAO.addAnimal(new Animal("Тигр", "Амурский тигр", 3, "Лес", "Здоров"));

        // Выводим все животных
        System.out.println("Все животные:");
        for (Animal animal : animalDAO.getAllAnimals()) {
            System.out.println(animal);
        }

        // Выводим конкретного животного по ID
        int animalId = 1; // например, по id 1
        Animal animal = animalDAO.getAnimalById(animalId);
        if (animal != null) {
            System.out.println("Животное с ID " + animalId + ":");
            System.out.println(animal);
        } else {
            System.out.println("Животное с ID " + animalId + " не найдено.");
        }

        // Обновляем данные животного
        if (animal != null) {
            animal.setHealthStatus("Болезненно");
            animalDAO.updateAnimal(animal);
            System.out.println("Данные животного после обновления:");
            System.out.println(animalDAO.getAnimalById(animalId));
        }

//        // Удаляем животное
//        int animalIdToDelete = 2; // животное с id 2
//        animalDAO.deleteAnimal(animalIdToDelete);
//        System.out.println("Животное с ID " + animalIdToDelete + " было удалено.");
    }
}
