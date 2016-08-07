public class Fragrance {

    String name;
    String ingredients;

    public Fragrance(String name, String ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String toString() { return "Fragrance: "+ name + ingredients + "";}
}
