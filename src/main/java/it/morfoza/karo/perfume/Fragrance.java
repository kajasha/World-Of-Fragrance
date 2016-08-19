package it.morfoza.karo.perfume;

public class Fragrance {

    private String name;
    private String ingredients;

    public Fragrance(String name, String ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String toString() {
        return "it.morfoza.karo.perfume.Fragrance: " + name + ingredients + "";
    }

    @Override
    public boolean equals(Object object) {
        Fragrance fragrance1 = this;
        Fragrance fragrance2 = (Fragrance) object;
        if (fragrance1.name.equals(fragrance2.name)) {
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public boolean matches(String search) {
        if (name.contains(search) || ingredients.contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public String[] getIngriditensTable() {
        return ingredients.split(",");
    }
}

