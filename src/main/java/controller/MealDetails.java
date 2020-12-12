package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MealDetails extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        request.setAttribute("meal", service.getMealWithName(name));
        System.out.println(service.getMealWithName(name).getName());
        return "meal.jsp";
    }
}
