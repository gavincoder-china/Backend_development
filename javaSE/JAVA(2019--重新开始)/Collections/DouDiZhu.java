import java.util.ArrayList;
import java.util.Collections;

public class DouDiZhu {
    public static void main(String[] args) {


        //1.准备牌
//    /定义一个存储 54 张 pai 的 Arraylist 集合,泛型使用 string

        ArrayList<String> poker = new ArrayList<>();
        //定义两个数组,一个存储牌的花色,一个存储牌的序号
        String[] color = {"梅花", "红心", "黑桃", "方片"};
        String[] numbers = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};

        //先把大小王存到 poker 集合中
        poker.add("大王");
        poker.add("小王");
        //循环嵌套两个数组,组装 52 张牌
        for (String number : numbers) {
            for (String c : color) {
                //System.out.println(c+number);
                poker.add(c + number);
            }
        }

        //2.洗牌
        //使用集合的工具类 shuffle  静态方法
        Collections.shuffle(poker);

        //  System.out.println(poker);

//3.发牌
        //定义四个集合,存储玩家牌和底牌
        ArrayList<String> player01 = new ArrayList<>();
        ArrayList<String> player02 = new ArrayList<>();
        ArrayList<String> player03 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();

        //遍历 poker 集合,获取每一张牌,使用索引%#,给三个玩家轮流发牌,
        //最后剩余三张给底牌
        //注意:先判断底牌 i>=51

        for (int i = 0; i < poker.size(); i++) {
            //获取一张牌
            String p = poker.get(i);
            //轮流发牌
            if (i >= 51) {
                //给底牌发牌
                dipai.add(p);

            } else if (i % 3 == 0) {
                player01.add(p);
            } else if (i % 3 == 1) {
                player02.add(p);
            } else if (i % 3 == 2) {
                player03.add(p);
            }

        }


        //4.看牌
        System.out.println("player01"+player01);
        System.out.println("player02"+player02);
        System.out.println("player03"+player03);
        System.out.println("dipai"+dipai);
    }

}
