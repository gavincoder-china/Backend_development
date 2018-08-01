/**
 * @author Administrator
 */ /*
        _                         _             
                                        (_)                       | |            
                     __ _   __ _ __   __ _  _ __    ___  ___    __| |  ___  _ __ 
                    / _` | / _` |\ \ / /| || '_ \  / __|/ _ \  / _` | / _ \| '__|
                   | (_| || (_| | \ V / | || | | || (__| (_) || (_| ||  __/| |   
                    \__, | \__,_|  \_/  |_||_| |_| \___|\___/  \__,_| \___||_|   
                     __/ |                                                       
                    |___/  


*/
/*现在有20位顾客，年龄段从4~60,其中4~11为儿童，12~17少年，18~30青年，
31~50中年，50以上为老年
最后打印出每个年龄段的占比
for(int i=4;i<=60;i==){
}*/
public class ghent {






    public static void main(String[] args) {

        int[] ager = {4, 5, 6, 7, 8, 12, 26, 18, 21, 56, 65, 10, 55, 35, 36, 29, 54, 36, 33, 45};
        double count_child = 0;
        double count_teen = 0;
        double count_young = 0;
        double count_middle = 0;
        double count_elder = 0;
        int age;

        for (int i = 0; i < 20; i++) {

            age = ager[i];

            if (age >= 4 && age < 11) {
                count_child = count_child + 1;
            } else if (age >= 12 && age < 18) {

                count_teen = count_teen + 1;

            } else if (age >= 18 && age < 31) {

                count_young = count_young + 1;
            } else if (age >= 31 && age < 51) {

                count_middle = count_middle + 1;
            } else if (age >= 51) {
                count_elder = count_elder + 1;
            }
        }

        System.out.println("儿童顾客人数有" + ((int) count_child) + "位，占比为" + ((int) (count_child / 20 * 100))+"%");
        System.out.println("少年顾客人数有" + ((int) count_teen) + "位，占比为" + ((int) (count_teen / 20 * 100))+"%");
        System.out.println("青年顾客人数有" + ((int) count_young) + "位，占比为" + ((int) (count_young / 20 * 100))+"%");
        System.out.println("中年顾客人数有" + ((int) count_middle) + "位，占比为" + ((int) (count_middle / 20 * 100))+"%");
        System.out.println("老年顾客人数有" + ((int) count_elder) + "位，占比为" + ((int) (count_elder / 20 * 100))+"%");




}}
