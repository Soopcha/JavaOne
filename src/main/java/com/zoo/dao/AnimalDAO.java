package com.zoo.dao;

import com.zoo.db.DatabaseConnection;
import com.zoo.model.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//http://localhost:8080/JavaOne_war_exploded/animals

// Этот класс выполняет CRUD-операции с таблицей animals
//Singleton — это паттерн проектирования, который гарантирует, что у класса будет только один обьект на всё приложение.
public class AnimalDAO {

    private static AnimalDAO instance; //Статическая переменная, где будет храниться единственный экземпляр класса

    private AnimalDAO() {}//Приватный конструктор. Это не даёт создавать new AnimalDAO() извне. Только внутри класса

    public static synchronized AnimalDAO getInstance() {
        if (instance == null) {
            instance = new AnimalDAO();
        }
        return instance;
    }
    //Метод getInstance() возвращает уже созданный объект. Если он ещё не создан — создаёт
    //synchronized нужен, если вдруг приложение многопоточное — чтобы два потока не создали 2 экземпляра

    // Получить список всех животных
    public List<Animal> getAllAnimals() {
        List<Animal> animals = new ArrayList<>();
        String query = "SELECT * FROM animals";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Animal animal = new Animal(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("species"),
                        resultSet.getInt("age"),
                        resultSet.getString("habitat"),
                        resultSet.getString("health_status")
                );
                animals.add(animal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animals;
    }

    // Получить одно животное по ID
    public Animal getAnimalById(int id) {
        String query = "SELECT * FROM animals WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Animal(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("species"),
                        resultSet.getInt("age"),
                        resultSet.getString("habitat"),
                        resultSet.getString("health_status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Вставить новое животное
    public void insertAnimal(Animal animal) {
        String query = "INSERT INTO animals (name, species, age, habitat, health_status) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, animal.getName());
            statement.setString(2, animal.getSpecies());
            statement.setInt(3, animal.getAge());
            statement.setString(4, animal.getHabitat());
            statement.setString(5, animal.getHealthStatus());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Обновить животное
    public void updateAnimal(Animal animal) {
        String query = "UPDATE animals SET name = ?, species = ?, age = ?, habitat = ?, health_status = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, animal.getName());
            statement.setString(2, animal.getSpecies());
            statement.setInt(3, animal.getAge());
            statement.setString(4, animal.getHabitat());
            statement.setString(5, animal.getHealthStatus());
            statement.setInt(6, animal.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Удалить животное
    public void deleteAnimal(int id) {
        String query = "DELETE FROM animals WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

