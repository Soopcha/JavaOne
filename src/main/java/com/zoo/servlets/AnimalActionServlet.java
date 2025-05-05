package com.zoo.servlets;

import com.zoo.dao.AnimalDAO;
import com.zoo.model.Animal;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AnimalActionServlet extends HttpServlet {


    private AnimalDAO animalDao;

    @Override
    public void init() {
        animalDao = new AnimalDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        request.setCharacterEncoding("UTF-8"); // чтобы русский не кракозябрился

        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));

        if ("delete".equals(action)) {
            // Удаление
            animalDao.deleteAnimal(id);
        } else {
            // Получаем остальные параметры
            String name = request.getParameter("name");
            String species = request.getParameter("species");
            int age = Integer.parseInt(request.getParameter("age"));
            String habitat = request.getParameter("habitat");
            String healthStatus = request.getParameter("healthStatus");

            Animal animal = new Animal(id, name, species, age, habitat, healthStatus);

            if (id == 0) {
                // Добавление нового животного
                animalDao.insertAnimal(animal);
            } else {
                // Обновление существующего
                animalDao.updateAnimal(animal);
            }
        }

        // Перенаправление обратно на список
        response.sendRedirect("animals");
    }
}
