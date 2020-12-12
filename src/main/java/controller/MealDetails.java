package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MealDetails extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        request.setAttribute("meals", service.getMealsWithName(name));
        System.out.println(service.getMealsWithName(name).getName());
        return "patients.jsp";
    }
}
