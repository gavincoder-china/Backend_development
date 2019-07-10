import java.util.List;
import java.util.Map;

public class Of_jdk9新方法 {
    /*
     * JDK9 新增加了 of 方法
     *     list,map,set 接口的静态方法,可以给集合一次性添加多个元素
     *
     *    使用前提:
     *         当确定存储元素个数的时候,且后续无法增加改变删除元素
     *
     * 注意:
     *      1.只适用于 list,map,set ,不适用其实现类
     *      2.返回的集合不可改变,无法使用 add,put,remove 等方法
     *      3.map,set 中不能存入重复元素
     *
     *
     * */

    public static void main(String[] args) {


        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(list);

        //  list.remove(1);  //UnsupportedOperationException  不支持的操作异常的操作
        //  System.out.println(list);

        ///不可存入重复的元素
        Map<Integer, Integer> map = Map.of(1, 1, 2, 2);

        System.out.println(map);
    }
}
