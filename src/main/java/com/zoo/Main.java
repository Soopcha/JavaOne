package com.zoo;


import com.zoo.dao.AnimalDAO;
import com.zoo.db.DatabaseConnection;
import com.zoo.db.DatabaseInitializer;
import com.zoo.model.Animal;
import com.zoo.service.AnimalService;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public  static void main(String[] args) {
        // Проверка загрузки файла из ресурсов
        try (InputStream is = Main.class.getClassLoader().getResourceAsStream("generate_test_data.sql")) {
            if (is == null) {
                System.err.println("ОШИБКА: Файл generate_test_data.sql не найден в ресурсах!");
            } else {
                System.out.println("Файл generate_test_data.sql успешно найден");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Инициализация БД
        DatabaseInitializer.initializeDatabase();

        AnimalService animalService = AnimalService.getInstance();

        // Просто проверяем работу сервиса
        System.out.println("Все животные:");
        animalService.getAllAnimals().forEach(System.out::println);

        // Пример получения одного животного
        int animalId = 1;
        System.out.println("\nЖивотное с ID " + animalId + ":");
        System.out.println(animalService.getAnimalById(animalId));
    }


}
