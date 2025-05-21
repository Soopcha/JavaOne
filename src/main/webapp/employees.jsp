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

<h1>Список сотрудников</h1>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>ФИО</th>
        <th>Должность</th>
        <th>Зарплата</th>
        <th>Телефон</th>
        <th>Действия</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.fullName}</td>
            <td>${employee.position}</td>
            <td>${employee.salary}</td>
            <td>${employee.phone}</td>
            <td>
                <input type="button" value="Редактировать"
                       onclick="fillEditForm('${employee.id}', '${employee.fullName}', '${employee.position}', '${employee.salary}', '${employee.phone}')"/>

                <form method="post" action="employeeAction" style="display:inline">
                    <input type="hidden" name="id" value="${employee.id}"/>
                    <input type="hidden" name="action" value="delete"/>
                    <input type="submit" value="Удалить"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Форма добавления нового сотрудника -->
<h2>Добавить нового сотрудника</h2>
<form method="post" action="employeeAction">
    <input type="hidden" name="id" value="0"/>
    ФИО: <input type="text" name="fullName"/><br>
    Должность: <input type="text" name="position"/><br>
    Зарплата: <input type="number" step="0.01" name="salary"/><br>
    Телефон: <input type="text" name="phone"/><br>
    <input type="submit" value="Добавить"/>
</form>

<!-- Форма редактирования сотрудника -->
<h2>Редактировать сотрудника</h2>
<form method="post" action="employeeAction">
    ID: <input type="number" name="id" id="edit-id" readonly/><br>
    ФИО: <input type="text" name="fullName" id="edit-fullName"/><br>
    Должность: <input type="text" name="position" id="edit-position"/><br>
    Зарплата: <input type="number" step="0.01" name="salary" id="edit-salary"/><br>
    Телефон: <input type="text" name="phone" id="edit-phone"/><br>
    <input type="submit" value="Обновить"/>
</form>

<!-- Кнопки навигации -->
<form action="animals" method="get">
    <input type="submit" value="Перейти к животным">
</form>

<form action="tickets" method="get">
    <input type="submit" value="Перейти к билетам">
</form>

<form action="index.jsp" method="get">
    <input type="submit" class="back-button" value="Назад на главную">
</form>

<script>
    function fillEditForm(id, fullName, position, salary, phone) {
        document.getElementById('edit-id').value = id;
        document.getElementById('edit-fullName').value = fullName;
        document.getElementById('edit-position').value = position;
        document.getElementById('edit-salary').value = salary;
        document.getElementById('edit-phone').value = phone;
        window.scrollTo(0, document.body.scrollHeight);
    }
</script>

</body>
</html>