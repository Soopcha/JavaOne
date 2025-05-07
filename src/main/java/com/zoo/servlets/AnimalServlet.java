package com.zoo.servlets;

import com.zoo.dao.AnimalDAO;
import com.zoo.model.Animal;

import com.zoo.service.AnimalService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//Сервлет — это контроллер. Он:
//Получает HTTP-запрос от браузера.
//Вызывает нужную бизнес-логику (через AnimalService → AnimalDAO).
//Передаёт данные на JSP-страницу для отображения (в нашем случае animals.jsp).

public class AnimalServlet extends HttpServlet { //Наследуемся от HttpServlet, значит — можем обрабатывать HTTP-запросы: GET, POST, и т.д.
    private AnimalService animalService;

    @Override
    public void init() throws ServletException {
        this.animalService = AnimalService.getInstance();
    } //Мы инициализируем animalService, используя Singleton — getInstance()

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        List<Animal> animals = animalService.getAllAnimals();
        System.out.println("animals in JSP: " + animals);

        request.setAttribute("animals", animals);
        request.getRequestDispatcher("/animals.jsp").forward(request, response);
    }
}
