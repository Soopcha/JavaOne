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
//Этот класс отвечает за обработку HTTP-запросов, связанных с животными
//Как связан с другими классами:
//Он получает список животных из базы данных с помощью AnimalDAO
//Передаёт этот список на страницу animals.jsp, где они отображаются

public class AnimalServlet extends HttpServlet {
    private AnimalService animalService;

    @Override
    public void init() throws ServletException {
        this.animalService = AnimalService.getInstance();
    }

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
