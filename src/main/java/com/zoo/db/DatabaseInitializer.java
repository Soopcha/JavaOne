package com.zoo.db;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseInitializer {

    public static void initializeDatabase() {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            // Создание таблицы животных
            String createAnimalsTable = "CREATE TABLE IF NOT EXISTS animals (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(100) NOT NULL, " +
                    "species VARCHAR(100) NOT NULL, " +
                    "age INTEGER, " +
                    "habitat VARCHAR(100), " +
                    "health_status VARCHAR(50)" +
                    ");";

            // Создание таблицы сотрудников
            String createEmployeesTable = "CREATE TABLE IF NOT EXISTS employees (" +
                    "id SERIAL PRIMARY KEY, " +
                    "full_name VARCHAR(100) NOT NULL, " +
                    "position VARCHAR(50) NOT NULL, " +
                    "salary DECIMAL(10, 2), " +
                    "phone VARCHAR(20)" +
                    ");";

            // Создание таблицы билетов
            String createTicketsTable = "CREATE TABLE IF NOT EXISTS tickets (" +
                    "id SERIAL PRIMARY KEY, " +
                    "visitor_name VARCHAR(100) NOT NULL, " +
                    "price DECIMAL(10, 2) NOT NULL, " +
                    "purchase_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                    ");";

            // Выполнение SQL-запросов
            statement.execute(createAnimalsTable);
            statement.execute(createEmployeesTable);
            statement.execute(createTicketsTable);

            System.out.println("Таблицы успешно созданы или уже существуют.");
        } catch (SQLException e) {
            System.err.println("Ошибка при создании таблиц: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        initializeDatabase();
    }
}
