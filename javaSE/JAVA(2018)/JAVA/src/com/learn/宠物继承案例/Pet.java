/*
        _                         _             
                                        (_)                       | |            
                     __ _   __ _ __   __ _  _ __    ___  ___    __| |  ___  _ __ 
                    / _` | / _` |\ \ / /| || '_ \  / __|/ _ \  / _` | / _ \| '__|
                   | (_| || (_| | \ V / | || | | || (__| (_) || (_| ||  __/| |   
                    \__, | \__,_|  \_/  |_||_| |_| \___|\___/  \__,_| \___||_|   
                     __/ |                                                       
                    |___/  


*/

package com.learn.宠物继承案例;

public class Pet {

    private String name;
    private int health;
    private int love;
    private String type;


    public Pet() {
        setName("xiaobai ");
        setHealth(10);
        setLove(0);

    }

    public void eat() {
        this.setHealth(getHealth() + 5);
        this.setLove(getLove() + 10);
    }

    public void feed(Pet pet) {

        pet.eat();
    }

    @Override
    public String toString() {
        String printstring = "name=" + getName() + "\n" + "health=" + getHealth() + "\n" + "love=" + getLove() + "\n" + "type" + getType() + "\n";
        return printstring;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void play(Pet pet) {


        if (pet instanceof Dog) {
            Dog dog = (Dog) pet;
            dog.run();
        } else if (pet instanceof Cat) {

            Cat cat = (Cat) pet;
            cat.Climb();

        }
    }
       public Pet getType(String type){
        switch (type){
            case "dog":
                Dog dog=new Dog();
                return dog;
            case "cat":
                Cat cat=new Cat();
                return cat;
            default:
                System.out.println("您输入的值无效");
                return  null;



        }


       }
    

}
