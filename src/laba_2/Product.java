package laba_2;

public class Product {
    String name;
    double protein;
    double fats;
    double carbohydrates;
    double calories;

    Product(String name, double protein, double fats, double carbohydrates, double calories) {
        this.name = name;
        this.protein = protein;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
        this.calories = calories;
    }

    Product(String name) {
        this.name = name;
        switch (name) {
            case "Cesar" -> {
                protein = 14.8;
                fats = 17.2;
                carbohydrates = 3.4;
                calories = 188.5;
            }
            case "California" -> {
                protein = 403;
                fats = 16.2;
                carbohydrates = 14.5;
                calories = 51.5;
            }
            case "Filadelfia" -> {
                protein = 390;
                fats = 23.4;
                carbohydrates = 13.3;
                calories = 44.2;
            }
            case "Fried duck" -> {
                protein = 22.6;
                fats = 19.5;
                carbohydrates = 0;
                calories = 266;
            }
            case "Uha" -> {
                protein = 3.4;
                fats = 1;
                carbohydrates = 5.5;
                calories = 46;
            }
        }
    }

    double getTotalProtein(int grams) {
        return (double) (grams) / 100.0 * protein;
    }

    double getTotalFats(int grams) {
        return (double) (grams) / 100.0 * fats;
    }

    double getTotalCarbohydrates(int grams) {
        return (double) (grams) / 100.0 * carbohydrates;
    }

    double getTotalCalories(int grams) {
        return (double) (grams) / 100.0 * calories;
    }


}
