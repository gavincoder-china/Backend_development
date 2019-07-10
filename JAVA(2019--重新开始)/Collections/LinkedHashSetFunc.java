import java.util.LinkedHashSet;

public class LinkedHashSetFunc {

    /*
    * 在 hashset的基础上实现了有序
    *
    * */
    public static void main(String[] args) {


        LinkedHashSet<Integer> linked=new LinkedHashSet<>();

        linked.add(1);
        linked.add(2);
        linked.add(4);
        linked.add(3);
        linked.add(6);
        System.out.println(linked);
        //顺序不变
    }
}
