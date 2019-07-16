
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DouDiZhu02 {
    /*
     * 斗地主综合案例(有序版本)
     *
     * 1.准备牌
     * 2.洗牌
     * 3.发牌
     * 4.排序
     * 5.看牌
     * */

    public static void main(String[] args) {
//1.准备牌
        //创建 maHash,存储牌的索引与组装好的牌
        HashMap<Integer, String> poker = new HashMap<>();
        //Arraylist 集合,存储牌的索引
        ArrayList<Integer> pokerIndex = new ArrayList<>();
        //定义两个集合,存储花色与牌号
        List<String> colors = List.of("♠️", "♥️", "♣️", "♦️");
        List<String> numbers = List.of("2", "A", "K", "Q", "J",
                                       "10", "9", "8", "7", "6", "5", "4", "3");
        //把大小王存到集合中
        //定义一个牌的索引
        int index = 0;
        poker.put(index, "大王");
        pokerIndex.add(index);
        index++;

        poker.put(index, "小王");
        pokerIndex.add(index);
        index++;

        //存储 52 张牌,循序嵌套遍历两个集合,存储到集合中

        for (String number : numbers) {

            for (String color : colors) {

                poker.put(index, color + number);
                pokerIndex.add(index);
                index++;
            }
        }
/*
        System.out.println(poker);
        System.out.println(pokerIndex);
*/
        //2.洗牌
        //使用 shuffle
        // 打乱前查看
        // for (Integer i : pokerIndex) {
        //       System.out.println(i+" :"+pokerIndex.get(i));
        //      }
        Collections.shuffle(pokerIndex);
        //测试是否打乱
        //        for (Integer i : pokerIndex) {
        //            System.out.println(i+" :"+pokerIndex.get(i));
        //        }
        //   System.out.println(pokerIndex);


//3.发牌
        //定义四个集合,存储玩家牌与底牌索引
        ArrayList<Integer> player01 = new ArrayList<>();
        ArrayList<Integer> player02 = new ArrayList<>();
        ArrayList<Integer> player03 = new ArrayList<>();
        ArrayList<Integer> dipai = new ArrayList<>();
//遍历存储索引牌索引的 list 集合,获取每一个牌的索引
        for (int i = 0; i < pokerIndex.size(); i++) {
            Integer in = pokerIndex.get(i);
            //先判断%是多少,再发给对应的玩家
            if (i >= 51) {
                //给底牌发牌
                dipai.add(in);
            } else if (i % 3 == 0) {
                player01.add(in);
            } else if (i % 3 == 1) {
                player02.add(in);
            } else if (i % 3 == 2) {
                player03.add(in);
            }


        }

        //4.排序
        //使用 collections 中的 sort 方法,默认升序排序
        Collections.sort(player01);
        Collections.sort(player02);
        Collections.sort(player03);
        Collections.sort(dipai);

        //5.看牌
       /* System.out.println(player01);
        System.out.println(player02);
        System.out.println(player03);
        System.out.println(dipai);*/
        lookPoker("甲", poker, player01);
        lookPoker("乙", poker, player02);
        lookPoker("丙", poker, player03);
        lookPoker("底牌", poker, dipai);

    }

    //定义一个看牌的静态方法,提高代码的复用性
    //参数:
    //string name:玩家名称
    //存储牌poker的集合
    //存储玩家和底牌的 list 集合
    //查表法:
    //   遍历玩家或者底牌集合,获取牌的索引
    //   使用牌的索引,去 map 中找到对应的牌
    private static void lookPoker(String name, HashMap<Integer, String> poker, ArrayList<Integer> list) {
        //输出玩家名称,不换行
        System.out.print(name + ": ");
        //遍历玩家或者底牌集合,获取牌的索引
        for (Integer key : list) {
            String value = poker.get(key);
            System.out.print(value + " ");

        }
        System.out.println();//换行
    }
}
