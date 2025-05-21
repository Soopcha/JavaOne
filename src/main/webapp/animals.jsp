<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Список животных</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 30px;
            color: #fff;
            position: relative;
            min-height: 100vh;
            z-index: 1;
        }

        body::before {
            content: "";
            position: fixed;
            top: 0; left: 0;
            width: 100%; height: 100%;
            background-image: url("https://img3.akspic.ru/crops/0/0/0/6/2/126000/126000-bolshaya_koshka-nazemnye_zhivotnye-hishhnik-bengalskij_tigr-tigr-3840x2160.jpg");
            background-size: cover;
            background-position: center;
            filter: blur(0px) brightness(0.26);
            z-index: -1;
        }

        table, input, form {
            color: #000000;
        }

        th {
            background-color: #c65b61;
            color: white;
        }

        input[type="submit"], input[type="button"] {
            background-color: #c65b61;
            color: white;
        }

        .back-button {
            background-color: #95a5a6;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
            margin-bottom: 30px;
            color: white;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
            color: white;
        }

        h1, h2 {
            font-family: Arial, sans-serif;
            color: white;
            display: flex;
            font-size: 2em;
            margin-bottom: 20px;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            text-shadow: 1px 1px 4px #000;
        }



        th {
            background-color: #c65b61;
            color: white;
        }

        tr:nth-child(even) {
            background-color: transparent;
        }

        input[type="text"], input[type="number"] {
            padding: 6px;
            margin: 4px 0;
            width: 250px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"], input[type="button"] {
            background-color: #c65b61;
            color: white;
            border: none;
            padding: 8px 16px;
            margin-top: 6px;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover, input[type="button"]:hover {
            background-color: #c65b61;
        }

        form {
            margin-bottom: 20px;
        }

        .back-button {
            background-color: #95a5a6;
            margin-top: 20px;
            display: inline-block;
        }

        .back-button:hover {
            background-color: #7f8c8d;
        }

        input[type="text"], input[type="number"] {
            padding: 6px;
            margin: 4px 0;
            width: 250px;
            border: 1px solid rgba(255, 255, 255, 0.5); /*  Белая полупрозрачная рамка */
            border-radius: 4px;
            background-color: transparent; /* Прозрачный фон */
            color: white; /*  Белый цвет текста внутри полей */
        }

        input {
            color: white; /* Белый цвет для всего текста в input */
        }
        form {
            margin-bottom: 20px;
            color: white; /* Белый цвет для текста меток в форме */
        }



    </style>
</head>
<body>

<h1>Список животных</h1>

<table>
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
                <input type="button" value="Редактировать"
                       onclick="fillEditForm('${animal.id}', '${animal.name}', '${animal.species}', '${animal.age}', '${animal.habitat}', '${animal.healthStatus}')"/>

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

<!-- Кнопка назад -->
<form action="index.jsp" method="get">
    <input type="submit" class="back-button" value="Назад на главную">
</form>
<!-- Кнопка перехода к билетам -->
<form action="tickets" method="get">
    <input type="submit" value="Перейти к билетам">
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
