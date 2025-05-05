<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Animals</title>
</head>
<body>
<h1>Список животных</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Вид</th>
        <th>Возраст</th>
        <th>Среда</th>
        <th>Здоровье</th>
        <th>Действия</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="animal" items="${animals}">
        <tr>
            <td>${animal.id}</td>
            <td>${animal.name}</td>
            <td>${animal.species}</td>
            <td>${animal.age}</td>
            <td>${animal.habitat}</td>
            <td>${animal.healthStatus}</td>
            <td>
                <!-- Кнопка для передачи данных в форму редактирования -->
                <input type="button" value="Редактировать"
                       onclick="fillEditForm('${animal.id}', '${animal.name}', '${animal.species}', '${animal.age}', '${animal.habitat}', '${animal.healthStatus}')"/>

                <!-- Форма удаления -->
                <form method="post" action="animalAction" style="display:inline">
                    <input type="hidden" name="id" value="${animal.id}"/>
                    <input type="hidden" name="action" value="delete"/>
                    <input type="submit" value="Удалить"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- ===== Добавление нового животного ===== -->
<h2>Добавить новое животное</h2>
<form method="post" action="animalAction">
    <input type="hidden" name="id" value="0"/>
    Имя: <input type="text" name="name"/><br>
    Вид: <input type="text" name="species"/><br>
    Возраст: <input type="number" name="age"/><br>
    Среда обитания: <input type="text" name="habitat"/><br>
    Состояние здоровья: <input type="text" name="healthStatus"/><br>
    <input type="submit" value="Добавить"/>
</form>

<!-- ===== Редактирование животного ===== -->
<h2>Редактировать животное</h2>
<form method="post" action="animalAction">
    ID: <input type="number" name="id" id="edit-id" readonly/><br>
    Имя: <input type="text" name="name" id="edit-name"/><br>
    Вид: <input type="text" name="species" id="edit-species"/><br>
    Возраст: <input type="number" name="age" id="edit-age"/><br>
    Среда обитания: <input type="text" name="habitat" id="edit-habitat"/><br>
    Состояние здоровья: <input type="text" name="healthStatus" id="edit-healthStatus"/><br>
    <input type="submit" value="Обновить"/>
</form>

<!-- ===== JavaScript для заполнения формы редактирования ===== -->
<script>
    function fillEditForm(id, name, species, age, habitat, healthStatus) {
        document.getElementById('edit-id').value = id;
        document.getElementById('edit-name').value = name;
        document.getElementById('edit-species').value = species;
        document.getElementById('edit-age').value = age;
        document.getElementById('edit-habitat').value = habitat;
        document.getElementById('edit-healthStatus').value = healthStatus;
        window.scrollTo(0, document.body.scrollHeight);
    }
</script>
</body>
</html>
