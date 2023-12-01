package laba_4;

public class Citizen {

    protected static final double rate = 2.5;

    public enum MONTH {
        JANUARY,
        FEBRUARY,
        MARCH,
        APRIL,
        MAY,
        JUNE,
        JULY,
        AUGUST,
        SEPTEMBER,
        OCTOBER,
        NOVEMBER,
        DECEMBER
    }

    private double[] electricity;

    public Citizen() {
        electricity = new double[365];
    }

    public void setElectricity() {
        for (int i = 0; i < electricity.length; ++i) {
            electricity[i] = Math.abs(Math.random());
        }
    }

    public double getElectricityReport(MONTH month) {
        double sum = 0.0;
        switch (month) {
            case JANUARY -> {
                for (int i = 0; i < 31; ++i) sum += electricity[i];
            }
            case FEBRUARY -> {
                for (int i = 31; i < 59; ++i) sum += electricity[i];
            }
            case MARCH -> {
                for (int i = 59; i < 90; ++i) sum += electricity[i];
            }
            case APRIL -> {
                for (int i = 90; i < 120; ++i) sum += electricity[i];
            }
            case MAY -> {
                for (int i = 120; i < 151; ++i) sum += electricity[i];
            }
            case JUNE -> {
                for (int i = 151; i < 181; ++i) sum += electricity[i];
            }
            case JULY -> {
                for (int i = 181; i < 212; ++i) sum += electricity[i];
            }
            case AUGUST -> {
                for (int i = 212; i < 243; ++i) sum += electricity[i];
            }
            case SEPTEMBER -> {
                for (int i = 243; i < 273; ++i) sum += electricity[i];
            }
            case OCTOBER -> {
                for (int i = 273; i < 304; ++i) sum += electricity[i];
            }
            case NOVEMBER -> {
                for (int i = 304; i < 334; ++i) sum += electricity[i];
            }
            case DECEMBER -> {
                for (int i = 334; i < 365; ++i) sum += electricity[i];
            }
        }
        return sum;
    }
    public double getElectricityReport() {
        double sum = 0.0;
        for (int i = 0; i < electricity.length; ++i) sum += electricity[i];
        return sum;
    }

    public double getPrice(MONTH month) {
        return getElectricityReport(month) * rate;
    }

    public MONTH getTheMostExpensiveMonth() {
        double max_sum = Double.NEGATIVE_INFINITY;
        MONTH max_month = MONTH.JANUARY;
        for (MONTH m : MONTH.values()) {
            double tmp_electricity = getElectricityReport(m);
            if (tmp_electricity > max_sum) {
                max_sum = tmp_electricity;
                max_month = m;
            }
        }
        return max_month;
    }

    public MONTH getTheMostCheapestMonth() {
        double min_sum = Double.POSITIVE_INFINITY;
        MONTH min_month = MONTH.JANUARY;
        for (MONTH m : MONTH.values()) {
            double tmp_electricity = getElectricityReport(m);
            if (tmp_electricity < min_sum) {
                min_sum = tmp_electricity;
                min_month = m;
            }
        }
        return min_month;
    }

    public int getTheMostExpensiveDay() {
        double max_sum = Double.NEGATIVE_INFINITY;
        int max_day = 1;
        for (int i = 0; i < electricity.length; ++i) {
            if (max_sum < electricity[i]) {
                max_sum = electricity[i];
                max_day = i + 1;
            }
        }
        return max_day;
    }

    public int getTheMostCheapestDay() {
        double min_sum = Double.POSITIVE_INFINITY;
        int min_day = 1;
        for (int i = 0; i < electricity.length; ++i) {
            if (min_sum > electricity[i]) {
                min_sum = electricity[i];
                min_day = i + 1;
            }
        }
        return min_day;
    }

    public double averageByMonth() {
        double months_sum = 0.0;
        for (MONTH m : MONTH.values()) {
            months_sum += getElectricityReport(m);
        }
        return months_sum / 12.0;
    }

    @Override
    public String toString() {
        return "Житель";
    }
}
