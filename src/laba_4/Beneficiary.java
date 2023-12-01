package laba_4;

public class Beneficiary extends Citizen {

    private static final double rate = 0.25;

    public Beneficiary() {
        super();
    }

    @Override
    public double getPrice(MONTH month) {
        return getElectricityReport(month) * rate;
    }

    @Override
    public String toString() {
        return "Льготник";
    }

}
