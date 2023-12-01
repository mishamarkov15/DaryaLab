package laba_5;

public class Human {
    private int age;  // Поле или атрибут
    private double weight;
    private int height;
    private char gender;

    private double calories;

    Human(int age, double weight, int height, char gender) {
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        calories = 0;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    double getDCI(double activity_coefficient) {
        return (weight * 10 + height * 6.25 - age * 5 + (gender == 'M' ? 5 : -161)) * activity_coefficient;
    }

    int getAge() {
        return age;
    }

    double getWeight() {
        return weight;
    }

    double getHeight() {
        return height;
    }

    char getGender() {
        return gender;
    }


    void setAge(int new_age) {
        age = new_age;
    }

    void setWeight(double new_weight) {
        weight = new_weight;
    }

    void setHeight(int new_height) {
        height = new_height;
    }

    void setGender(char new_gender) {
        height = new_gender;
    }

}
