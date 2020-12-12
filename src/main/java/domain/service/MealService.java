package domain.service;

import domain.model.Meal;
import java.util.ArrayList;
import java.util.List;

public class MealService {

    private static MealService INSTANCE;
    private List<Meal> meals = new ArrayList<Meal>();

    public MealService() {
    }

    public static MealService getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new MealService();
        }
        return INSTANCE;
    }

    public List<Meal> getAllMeals () {
        return meals;
    }

    public void add (Meal meal) {
        meals.add(meal);
    }

    public void deleteAll () {
        meals = new ArrayList<Meal>();
    }

    public Meal getMealWithName(String name) {
        for (Meal meal: meals) {
            if (meal.getName().equals(name)) {
                return meal;
            }
        }
        return null;
    }
}
