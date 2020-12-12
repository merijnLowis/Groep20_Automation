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
        Boolean vegetarian = checkBoxToBoolean(request.getParameter("vegetarian"));
        Boolean lactose = checkBoxToBoolean(request.getParameter("lactose"));
        Boolean nuts = checkBoxToBoolean(request.getParameter("nuts"));
        Meal meal = new Meal(name, category, price, vegetarian, lactose, nuts);
        service.add(meal);
        return "index.jsp";
    }

    private Boolean checkBoxToBoolean(String s) {
        if (s == null || s.isEmpty()) return false;
        if (s.equals("on")) return true;
        return false;
    }
}
