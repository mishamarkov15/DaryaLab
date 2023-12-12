package laba_6;

import java.util.Random;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static int getRandom(int min, int max) {
        var random = new Random();
        return Math.abs(random.nextInt()) % (max - min + 1) + min;
    }

    public static Human[] createHumans(int size) {
        var humans = new Human[size];
        for (int i = 0; i < size; ++i) {
            humans[i] = new Human(getRandom(12, 65), getRandom(50, 120), getRandom(150, 200), (getRandom(10, 100) % 2 == 0 ? 'M' : 'W'), getRandom(0, 6));
            humans[i].setCalories(getRandom(1500, 4000));
        }
        return humans;
    }

    public static Product[] createMenu() {
        String line = "";
        String splitBy = ";";

        try {
            var menu = new Product[61];

            int i = 0;
            BufferedReader br = new BufferedReader(new FileReader("food.csv"));
            while ((line = br.readLine()) != null) {
                String[] product = line.split(splitBy);
                menu[i++] = new Product(product[0], Double.parseDouble(product[1]), Double.parseDouble(product[2]), Double.parseDouble(product[3]), getRandom(20, 500));
            }
            return menu;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void showCaloriesByHuman(Human[] humans) {
        for (int i = 0; i < humans.length; ++i) {
            System.out.printf("Human[%d] %.2f calories\n", i, humans[i].getCalories());
        }
    }

    public static void showHumans(Human[] humans) {
        for (int i = 0; i < humans.length; ++i) {
            System.out.printf("Human[%d]:\n---------\n%s\n\n", i, humans[i]);
        }
    }

    public static void addProductToHuman(Product[] menu, Human[] humans, int index) {
        var scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите продукт:\n" +
                    "-----------------");
            for (int i = 0; i < menu.length; ++i) {
                System.out.printf("[%d] %s (калорий/100гр %.2f)\n", i, menu[i], menu[i].getTotalCalories(100));
            }
            System.out.printf("%d. Выход\n", menu.length);

            System.out.print("Ваш выбор: ");
            int product_id = scanner.nextInt();
            if (product_id == menu.length) {
                break;
            }
            if (!(0 <= product_id && product_id < menu.length)) {
                System.out.println("Выбран несуществующий продукт!\n");
                continue;
            }

            System.out.print("Сколько грамм продукта добавить: ");
            int gramms = scanner.nextInt();

            humans[index].setCalories(humans[index].getCalories() + menu[product_id].getTotalCalories(gramms));
        }
    }

    public static void main(String[] args) {
        var humans = createHumans(4);
        var menu = createMenu();

        var scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Сравнение рациона человека с DCI");
            System.out.println("2. Очистка съеденных калорий для человека");
            System.out.println("3. Добавление съеденных калорий для человека");
            System.out.println("0. Выход");
            System.out.print("Ваш выбор: ");

            var cmd = scanner.next();
            switch (cmd) {
                case "0" -> {
                    System.out.println("До свидания!");
                    return;
                }
                case "1" -> {
                    showHumans(humans);
                    System.out.print("Ваш выбор: ");
                    int human_id = scanner.nextInt();
                    if (!(0 <= human_id && human_id < humans.length)) {
                        System.out.print("Неверный индекс!\n");
                        break;
                    }
                    System.out.printf("Потребляемые калории в рационе: %.2f\n", humans[human_id].getCalories());
                    System.out.printf("Необходимые калорие (DCI): %.2f\n", humans[human_id].getDCI());
                }
                case "2" -> {
                    showCaloriesByHuman(humans);
                    System.out.print("Ваш выбор: ");
                    int human_id = scanner.nextInt();
                    if (!(0 <= human_id && human_id < humans.length)) {
                        System.out.print("Неверный индекс!\n");
                        break;
                    }
                    humans[human_id].setCalories(0);
                }
                case "3" -> {
                    showCaloriesByHuman(humans);
                    System.out.print("Ваш выбор: ");
                    int human_id = scanner.nextInt();
                    if (!(0 <= human_id && human_id < humans.length)) {
                        System.out.print("Неверный индекс!\n");
                        break;
                    }
                    addProductToHuman(menu, humans, human_id);
                }
                default -> System.out.println("Указана неверная команда!");
            }
        }
    }
}
