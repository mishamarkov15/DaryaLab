package laba_3;

import laba_3.utils.Human;
import laba_3.utils.Product;

public class Main {
    public static void main(String[] args) {
        Product[] lunch = new Product[4];
        lunch[0] = new Product("Cesar");
        lunch[1] = new Product("California");
        lunch[2] = new Product("Filadelfia");
        lunch[3] = new Product("Uha");

        Product[] dinner = new Product[3];
        dinner[0] = new Product("Fried duck");
        dinner[1] = new Product("Borch", 4.4, 3.6, 5.5); // Борщ
        dinner[2] = new Product("Vinegret", 9.1, 13, 6.8);

        Human[] humans = new Human[2];
        humans[0] = new Human("Ivan", 21, 69.6, 175, 'M', 4);
        humans[1] = new Human("Ekaterina", 20, 49.6, 167, 'W', 5);

        for (int i = 0 ; i < humans.length; ++i) {
            System.out.printf("%s DCI: %.2f\n", humans[i].getName(), humans[i].getDCI());
        }

        double eaten_calories = 0.;
        for (int i = 0; i < lunch.length; ++i) {
            eaten_calories += lunch[i].getTotalCalories();
        }
        for (int i = 0; i < dinner.length; ++i) {
            eaten_calories += dinner[i].getTotalCalories();
        }

        System.out.printf("Eaten calories %.2f\n", eaten_calories);
        for (int i = 0 ; i < humans.length; ++i) {
            if (humans[i].getDCI() < eaten_calories) {
                System.out.printf("%s will not lose his/her weight\n", humans[i].getName());
            } else {
                System.out.printf("%s will lose his/her weight\n", humans[i].getName());
            }
        }
    }
}
