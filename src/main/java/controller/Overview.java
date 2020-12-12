package controller;

import domain.model.Patient;
import domain.service.MealService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Overview extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("patients", MealService.getInstance().getAllPatients());
        return "patients.jsp";
    }
}
