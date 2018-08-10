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

package 面向对象;

public class Pet {
    protected String name;
    protected String sex;
    protected String health;
    protected int love;
    protected String strain;

    public Pet() {

    }

    public Pet(String sex, String strain, String health, int love, String name) {

        this.sex = sex;
        this.health = health;
        this.love = love;
        this.strain = strain;
        this.name = name;

    }
     /**
     * @Description： 
     
     * @Param: []
     * @Return: java.lang.String
     * @Auther: Gavincoder
     * @Date: 2018/8/9
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public String getStrain() {
        return strain;
    }

    public void setStrain(String strain) {
        this.strain = strain;
    }

    public void eat() {
        System.out.println("我喜欢吃骨头");
    }

    public void sleep() {
        System.out.println("我会睡觉");
    }

    public void run() {
        System.out.println("我会奔跑");
    }
    public void drink() {
        System.out.println("我会喝水");
    }


}
class  Dog1 extends Pet{
    int iii;
    Dog1(){
        super();
    }

    Dog1(String sex, String strain, String health, int love, String name,int iii ){
        
        this.sex = sex;
        this.health = health;
        this.love = love;
        this.strain = strain;
        this.name = name;
        this.iii=iii;
    }



}