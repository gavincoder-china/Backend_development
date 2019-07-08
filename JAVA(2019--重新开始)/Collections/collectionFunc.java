import java.util.ArrayList;
import java.util.Collection;

public class collectionFunc {
    //java.util.Collection接口
// 所有单列集合的最顶层接口,定义了所有单列集合共性的方法
// 任意的单列集合都可以使用 collection 接口中的方法
    public static void main(String[] args) {
        //创建集合对象,可以使用多态
        Collection<String> coll = new ArrayList<>();
        System.out.println(coll);  //重写了 tostring方法 []

        //(1)添加元素,返回是 bool,一般返回 true ,可以不接收
        coll.add("gavin");
        coll.add("张三");
        coll.add("李四");
        coll.add("王五");
        coll.add("赵六");
        coll.add("田七");
        System.out.println(coll);

        //(2)remove 方法,把给定的元素在当前集合中删除,返回值也是 boolean
        //若集合中不存在该元素,返回 false
        coll.remove("gavin");
        System.out.println(coll);

        //(3)contains 判断是否包含给顶元素
        System.out.println(coll.contains("gavin"));
        System.out.println(coll.contains("李四"));

        //(4)isEmpty 判断当前集合是否是空,集合为空返回 true
        System.out.println(coll.isEmpty());
        //(5)size 返回集合中元素的个数
        System.out.println(coll.size());
        //toArray把集合变成数组,集合的泛型是 object
        Object[] arr = coll.toArray();
        for (Object x : arr
        ) {
            System.out.println(x);
        }
        //(6)clear 清空集合里所有元素,但是集合还存在
        coll.clear();
        System.out.println(coll);
        System.out.println(coll.isEmpty());

    }

}
