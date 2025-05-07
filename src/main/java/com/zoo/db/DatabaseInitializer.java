package com.zoo.db;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseInitializer {

    public static void initializeDatabase() {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            // Создание таблиц
            createTables(statement);

            // Загрузка тестовых данных
            loadTestData(connection);

            System.out.println("База данных успешно инициализирована с тестовыми данными.");
        } catch (SQLException e) {
            System.err.println("Ошибка при инициализации БД: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createTables(Statement statement) throws SQLException {
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

        statement.execute(createAnimalsTable);
        statement.execute(createEmployeesTable);
        statement.execute(createTicketsTable);
    }

    private static void loadTestData(Connection connection) {
        try (InputStream is = DatabaseInitializer.class.getClassLoader().getResourceAsStream("generate_test_data.sql")) {
            if (is == null) {
                System.err.println("Файл generate_test_data.sql не найден в ресурсах!");
                return;
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                 Statement stmt = connection.createStatement()) {

                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    // Пропускаем комментарии и пустые строки
                    if (!line.trim().startsWith("--") && !line.trim().isEmpty()) {
                        sb.append(line);
                        // Добавляем пробел вместо перевода строки
                        if (!line.trim().endsWith(";")) {
                            sb.append(" ");
                        }
                    }
                }

                // Разделяем SQL-запросы
                String[] queries = sb.toString().split(";");
                for (String query : queries) {
                    String trimmedQuery = query.trim();
                    if (!trimmedQuery.isEmpty()) {
                        try {
                            stmt.execute(trimmedQuery);
                        } catch (SQLException e) {
                            System.err.println("Ошибка выполнения запроса: " + trimmedQuery);
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Ошибка при загрузке тестовых данных: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        initializeDatabase();
    }
}
