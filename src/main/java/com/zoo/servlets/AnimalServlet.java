package com.zoo.servlets;

import com.zoo.dao.AnimalDAO;
import com.zoo.model.Animal;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
//Этот класс отвечает за обработку HTTP-запросов, связанных с животными
//Как связан с другими классами:
//Он получает список животных из базы данных с помощью AnimalDAO
//Передаёт этот список на страницу animals.jsp, где они отображаются

public class AnimalServlet extends HttpServlet {

    //метод срабатывает при GET-запросе
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получаем всех животных из базы данных
        AnimalDAO animalDAO = new AnimalDAO();
        List<Animal> animals = animalDAO.getAllAnimals();
        System.out.println("animals in JSP: " + animals); //сообщение что животные переданны в jsp

        // Передаем список животных в JSP
        request.setAttribute("animals", animals); //Записывает список животных в request, чтобы передать его на страницу animals.jsp.

        // Перенаправляем запрос на JSP страницу для отображения
        request.getRequestDispatcher("/animals.jsp").forward(request, response);
        //Передаёт управление animals.jsp, которая получает список животных и отображает их.
    }
}
