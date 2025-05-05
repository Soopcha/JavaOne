<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Онлайн Зоопарк</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background-image: url("https://img3.akspic.ru/crops/5/7/9/8/4/148975/148975-voda-nazemnye_zhivotnye-zoopark-zhivaya_priroda-morda-3840x2160.jpg");
            background-size: cover;
            background-position: center;
            height: 100vh;
            font-family: Arial, sans-serif;
            color: white;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            text-shadow: 1px 1px 4px #000;
        }
        h1 {
            font-size: 3em;
            margin-bottom: 30px;
        }
        .enter-button {
            padding: 15px 30px;
            font-size: 1.2em;
            background-color: rgba(0, 123, 255, 0.8);
            color: white;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            text-decoration: none;
        }
        .enter-button:hover {
            background-color: rgba(0, 100, 210, 0.9);
        }
    </style>
</head>
<body>
<h1>Онлайн Зоопарк</h1>
<a href="animals" class="enter-button">Войти</a>
</body>
</html>
