package laba_3.utils;

public class Product {
    String name;
    double protein;
    double fats;
    double carbohydrates;

    public Product(String name, double protein, double fats, double carbohydrates) {
        this.name = name;
        this.protein = protein;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public Product(String name) {
        this.name = name;
        switch (name) {
            case "Cesar" -> {
                protein = 14.8;
                fats = 17.2;
                carbohydrates = 3.4;
            }
            case "California" -> {
                protein = 403;
                fats = 16.2;
                carbohydrates = 14.5;
            }
            case "Filadelfia" -> {
                protein = 390;
                fats = 23.4;
                carbohydrates = 13.3;
            }
            case "Fried duck" -> {
                protein = 22.6;
                fats = 19.5;
                carbohydrates = 0;
            }
            case "Uha" -> {
                protein = 3.4;
                fats = 1;
                carbohydrates = 5.5;
            }
        }
    }

    public String getName() {
        return name;
    }

    public double getProtein() {
        return protein;
    }

    public double getFats() {
        return fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getTotalCalories() {
        switch (name) {
            case "California" -> {
                return 51.5;
            }
            case "Filadelfia" -> {
                return 44.2;
            }
            case "Fried duck" -> {
                return 266;
            }
            case "Uha" -> {
                return 46;
            }
            default -> {
                return fats * 9.29 + protein * 4.1 + carbohydrates * 4.1;
            }
        }
    }

}
