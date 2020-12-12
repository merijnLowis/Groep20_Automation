package controller;

import domain.model.Meal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        double price = Double.parseDouble(request.getParameter("price"));
        Boolean vegetarian = request.getParameter("vegetarian") != null;
        Boolean lactose = request.getParameter("lactose") != null;
        Boolean nuts = request.getParameter("nuts") != null;
        Meal meal = new Meal(name, category, price, vegetarian, lactose, nuts);
        service.add(meal);
        return "index.jsp";
    }
}
