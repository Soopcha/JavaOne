<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Animals</title>
</head>
<body>
<h1>List of animals</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Type</th>
        <th>Age</th>
        <th>Environment</th>
        <th>Health</th>
    </tr>
    </thead>
    <tbody>
    <%-- Здесь будет выводиться список животных --%>
    <c:forEach var="animal" items="${animals}">
        <tr>
            <td>${animal.id}</td>
            <td>${animal.name}</td>
            <td>${animal.species}</td>
            <td>${animal.age}</td>
            <td>${animal.habitat}</td>
            <td>${animal.healthStatus}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
