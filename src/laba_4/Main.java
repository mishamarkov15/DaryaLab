package laba_4;

public class Main {
    public static void showElectricityForAll(Citizen[] citizens) {
        System.out.println("Общее потребление:");
        for (Citizen.MONTH m : Citizen.MONTH.values()) {
            double sum = 0.0;
            for (int i = 0; i < citizens.length; ++i) {
                sum += citizens[i].getElectricityReport(m);
            }
            System.out.printf("%s: %.2f кВтч\n", m.name(), sum);
        }
    }

    public static void showPriceForAll(Citizen[] citizens) {
        System.out.println("Общая стоимость:");
        for (Citizen.MONTH m : Citizen.MONTH.values()) {
            double sum = 0.0;
            for (int i = 0; i < citizens.length; ++i) {
                sum += citizens[i].getPrice(m);
            }
            System.out.printf("%s: %.2f₽\n", m.name(), sum);
        }
    }

    public static void showElectricityForCitizen(Citizen[] citizens) {
        for (int i = 0; i < citizens.length; ++i) {
            System.out.printf("\nПотребление %s %d\n", citizens[i], i + 1);
            for (Citizen.MONTH m : Citizen.MONTH.values()) {
                System.out.printf("%s: %.2f кВтч\n", m.name(), citizens[i].getElectricityReport(m));
            }
        }
    }

    public static void showPriceForCitizen(Citizen[] citizens) {
        for (int i = 0; i < citizens.length; ++i) {
            System.out.printf("\nОплата %s %d\n", citizens[i], i + 1);
            for (Citizen.MONTH m : Citizen.MONTH.values()) {
                System.out.printf("%s: %.2f ₽\n", m.name(), citizens[i].getPrice(m));
            }
        }
    }

    public static void showMaximumCitizens(Citizen[] citizens) {
        int[] maximums = new int[citizens.length];
        int curr_size = 0;
        for (Citizen.MONTH m : Citizen.MONTH.values()) {
            double max_electricity = Double.NEGATIVE_INFINITY;
            for (int i = 0; i < citizens.length; ++i) {
                double tmp_electricity = citizens[i].getElectricityReport(m);
                if (tmp_electricity > max_electricity) {
                    max_electricity = tmp_electricity;
                    maximums = new int[citizens.length];
                    curr_size = 0;
                    maximums[curr_size++] = i;
                } else if (Math.abs(tmp_electricity - max_electricity) < 0.001) {
                    maximums[curr_size++] = i;
                }
            }

            System.out.printf("Максимум(ы) за %s: ", m.name());
            for (int i = 0; i < curr_size; ++i) {
                System.out.printf("(%s %d) ", citizens[maximums[i]], maximums[i] + 1);
            }
            System.out.println();
        }

    }

    public static void showMinimumCitizens(Citizen[] citizens) {
        int[] minimums = new int[citizens.length];
        int curr_size = 0;
        for (Citizen.MONTH m : Citizen.MONTH.values()) {
            double max_electricity = Double.POSITIVE_INFINITY;
            for (int i = 0; i < citizens.length; ++i) {
                double tmp_electricity = citizens[i].getElectricityReport(m);
                if (tmp_electricity < max_electricity) {
                    max_electricity = tmp_electricity;
                    minimums = new int[citizens.length];
                    curr_size = 0;
                    minimums[curr_size++] = i;
                } else if (Math.abs(tmp_electricity - max_electricity) < 0.001) {
                    minimums[curr_size++] = i;
                }
            }

            System.out.printf("Минимум(ы) за %s: ", m.name());
            for (int i = 0; i < curr_size; ++i) {
                System.out.printf("(%s %d) ", citizens[minimums[i]], minimums[i] + 1);
            }
            System.out.println();
        }

    }

    public static void showMaximumCitizensByDay(Citizen[] citizens) {
        int index_of_max_citizen = 0;
        double max_day = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < citizens.length; ++i) {
            double tmp_day = citizens[i].getTheMostExpensiveDay();
            if (tmp_day > max_day) {
                max_day = tmp_day;
                index_of_max_citizen = i;
            }
        }
        System.out.printf("%s %d максимальое потребление за день: %.2f кВтч", citizens[index_of_max_citizen], index_of_max_citizen, max_day);
    }

    public static void showMinimumCitizensByDay(Citizen[] citizens) {
        int index_of_min_citizen = 0;
        double min_day = Double.POSITIVE_INFINITY;
        for (int i = 0; i < citizens.length; ++i) {
            double tmp_day = citizens[i].getTheMostCheapestDay();
            if (tmp_day < min_day) {
                min_day = tmp_day;
                index_of_min_citizen = i;
            }
        }
        System.out.printf("%s %d минимальное потребление за день: %.2f кВтч", citizens[index_of_min_citizen], index_of_min_citizen, min_day);
    }

    public static void main(String[] args) {
        Citizen[] citizens = new Citizen[8];
        for (int i = 0; i < 5; ++i) {
            citizens[i] = new Citizen();
            citizens[i].setElectricity();
        }
        for (int i = 0; i < 3; ++i) {
            citizens[5 + i] = new Beneficiary();
            citizens[5 + i].setElectricity();
        }

        showElectricityForAll(citizens);
        System.out.println();
        showPriceForAll(citizens);

        System.out.println();
        showElectricityForCitizen(citizens);
        showPriceForCitizen(citizens);

        showMaximumCitizens(citizens);
        System.out.println();
        showMinimumCitizens(citizens);

        showMaximumCitizensByDay(citizens);
        System.out.println();
        showMinimumCitizensByDay(citizens);
    }

}
