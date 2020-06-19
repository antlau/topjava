<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <title>Meal List</title>
    <style>
        .normal {color: green}
        .exceeded {color: red}
    </style>
</head>
<body>
<section>
    <h2><a href="index.html">Home</a></h2>
    <h3>Meal List</h3>
    <hr>
    <table border="1" cellspacing="8" cellpadding="0">
        <thead>
        <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        </tr>
        </thead>
        <c:forEach items="${mealList}" var="meal">
            <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.MealTo"/>
        <tr class="${meal.excess ? 'exceeded' : 'normal'}">
            <td>
                <%=TimeUtil.toString(meal.getDateTime())%>
            </td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
        </tr>
        </c:forEach>
</section>
</body>
</html>
