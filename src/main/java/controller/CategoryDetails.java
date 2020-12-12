package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoryDetails extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String category = request.getParameter("category");
        request.setAttribute("categoryName", category);
        request.setAttribute("categorymeals", service.getMealsWithCategories(category));
        return "category.jsp";
    }
}
