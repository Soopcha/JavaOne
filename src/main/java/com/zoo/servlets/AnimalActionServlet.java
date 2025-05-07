package com.zoo.servlets;

import com.zoo.dao.AnimalDAO;
import com.zoo.model.Animal;
import com.zoo.service.AnimalService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AnimalActionServlet extends HttpServlet {
    private AnimalService animalService;

    @Override
    public void init() throws ServletException {
        this.animalService = AnimalService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));

        if ("delete".equals(action)) {
            animalService.deleteAnimal(id);
        } else {
            String name = request.getParameter("name");
            String species = request.getParameter("species");
            int age = Integer.parseInt(request.getParameter("age"));
            String habitat = request.getParameter("habitat");
            String healthStatus = request.getParameter("healthStatus");

            Animal animal = new Animal(id, name, species, age, habitat, healthStatus);

            if (id == 0) {
                animalService.createAnimal(animal);
            } else {
                animalService.updateAnimal(animal);
            }
        }

        response.sendRedirect("animals");
    }
}
