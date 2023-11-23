package laba_2;

public class Main {
    public static void main(String[] args ) {
        var ivan = new Human(21, 81.2, 180, 'M');
        var katya = new Human(22, 50.8, 168, 'W');

        var ivan_dci = ivan.getDCI(1.46);
        var katya_dci = katya.getDCI(1.64);
        System.out.printf("Ivan DCI = %.2f\n", ivan_dci);
        System.out.printf("Katya DCI = %.2f\n", katya_dci);

        var cesar = new Product("Cesar");
        var california = new Product("California");
        var filadelfia = new Product("Filadelfia");
        var duck = new Product("Fried duck");
        var uha = new Product("Uha");

        System.out.printf("\nIvan eats 3000gr Cesar and 1000gr California roll.\n" +
                        "Protein: %.2f\n" +
                        "Fats: %.2f\n" +
                        "Carbohydrates: %.2f\n" +
                        "Calories: %.2f\n", cesar.getTotalProtein(3000) + california.getTotalProtein(1000),
                cesar.getTotalFats(3000) + california.getTotalFats(1000),
                cesar.getTotalCarbohydrates(3000) + california.getTotalCarbohydrates(1000),
                cesar.getTotalCalories(3000) + california.getTotalCalories(1000));
        if (cesar.getTotalCalories(3000) + california.getTotalCalories(1000) > ivan_dci) {
            System.out.print("Ivan will not lose his weight\n");
        } else {
            System.out.print("Ivan will lose his weight\n");
        }

        System.out.printf("\nKatya eats 100gr Filadelfia roll, 250gr Uha and 300gr Fried duck.\n" +
                        "Protein: %.2f\n" +
                        "Fats: %.2f\n" +
                        "Carbohydrates: %.2f\n" +
                        "Calories: %.2f\n", filadelfia.getTotalProtein(100) + uha.getTotalProtein(250) + duck.getTotalProtein(300),
                filadelfia.getTotalFats(100) + uha.getTotalFats(250) + duck.getTotalFats(300),
                filadelfia.getTotalCarbohydrates(100) + uha.getTotalCarbohydrates(250) + duck.getTotalCarbohydrates(300),
                filadelfia.getTotalCalories(100) + uha.getTotalCalories(250) + duck.getTotalCalories(300));
        if (filadelfia.getTotalCalories(100) + uha.getTotalCalories(250) + duck.getTotalCalories(300) > katya_dci) {
            System.out.print("Katya will not lose her weight\n");
        } else {
            System.out.print("Katya will lose his weight\n");
        }
    }
}
