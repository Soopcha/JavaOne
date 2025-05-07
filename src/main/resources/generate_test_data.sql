-- generate_test_data.sql
-- Очищаем таблицу (опционально)
--DELETE FROM animals;

-- Вставляем тестовые данные
INSERT INTO animals (name, species, age, habitat, health_status) VALUES
                                                                     ('Лев', 'Потомок льва', 5, 'Савана', 'Здоров'),
                                                                     ('Тигр', 'Амурский тигр', 3, 'Лес', 'Здоров'),
                                                                     ('Слон', 'Африканский слон', 10, 'Савана', 'Здоров');

INSERT INTO employees (full_name, position, salary, phone) VALUES
                                                               ('Иванов Иван', 'Ветеринар', 50000, '+79161234567'),
                                                               ('Петрова Мария', 'Смотритель', 40000, '+79167654321');

INSERT INTO tickets (visitor_name, price) VALUES
                                              ('Алексей Смирнов', 500),
                                              ('Елена Козлова', 300);