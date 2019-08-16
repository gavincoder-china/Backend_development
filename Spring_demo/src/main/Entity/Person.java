package main.Entity;

public class Person {
   private String name;
   private String gender;
   private Car car;

    @Override
    public String toString() {
        return "Person{" +
               "name='" + name + '\'' +
               ", gender='" + gender + '\'' +
               ", car=" + car +
               '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void eat() {
        System.out.println("大口吃肉");
    }
}