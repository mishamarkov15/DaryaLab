package laba_3.utils;

public class Human {
    private String name;
    private int age;  // Поле или атрибут
    private double weight;
    private int height;
    private char gender;

    private int activityID;

    public Human(String name, int age, double weight, int height, char gender, int activityID) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.activityID = activityID;
    }

    public double getDCI() {
        return (weight * 10 + height * 6.25 - age * 5 + (gender == 'M' ? 5 : -161)) * getActivityIDCoefficient();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public char getGender() {
        return gender;
    }

    public int getActivityID() {
        return activityID;
    }


    public void setName(String new_name) {
        name = new_name;
    }

    public void setAge(int new_age) {
        age = new_age;
    }

    public void setWeight(double new_weight) {
        weight = new_weight;
    }

    public void setHeight(int new_height) {
        height = new_height;
    }

    public void setGender(char new_gender) {
        height = new_gender;
    }

    public double getActivityIDCoefficient() {
        switch (activityID) {
            case 0 -> {
                return 1.2;
            }
            case 1 -> {
                return 1.38;
            }
            case 2 -> {
                return 1.46;
            }
            case 3 -> {
                return 1.55;
            }
            case 4 -> {
                return 1.64;
            }
            case 5 -> {
                return 1.73;
            } case 6 -> {
                return 1.9;
            }
            default -> {
                return 0.0;
            }
        }
    }

    public void setActivityID(int new_activityID) {
        if (0 < new_activityID || new_activityID > 6) {
            System.out.println("Error. Can not create activity ID with value not in range [0, 6]");
            activityID = 0;
        } else {
            activityID = new_activityID;
        }
    }

}
