package domain.model;

public class Meal {
    private String name;
    private  String category;
    private double price;
    private boolean gluten;
    private boolean vegetarian;
    private boolean containsLactose;
    private boolean containsNuts;

    public Meal(String name, String category, double price, Boolean vegetarian, Boolean lactose, Boolean nuts, Boolean gluten){
        setName(name);
        setCategory(category);
        setPrice(price);
        setVegetarian(vegetarian);
        setContainsLactose(lactose);
        setContainsNuts(nuts);
        setGluten(gluten);
    }

    public Meal(String name, String category, double price){
        setName(name);
        setCategory(category);
        setPrice(price);
        setVegetarian(false);
        setContainsLactose(false);
        setContainsNuts(false);
    }

    public Meal() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setContainsLactose(Boolean containsLactose) {
        this.containsLactose = containsLactose;
    }

    public Boolean getContainsLactose() {
        return containsLactose;
    }

    public void setContainsNuts(Boolean containsNuts) {
        this.containsNuts = containsNuts;
    }

    public Boolean getContainsNuts() {
        return containsNuts;
    }

    public void setGluten(Boolean gluten) {
        this.gluten = gluten;
    }

    public Boolean getGluten() {
        return gluten;
    }
}