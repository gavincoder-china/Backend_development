import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class iteratorFunc {


//iterator 迭代器,是一个接口,我们无法直接使用,
//所以需要使用其接口的实现类对象
//其获取实现类的方式比较特殊
//collection 接口中有个方法教 iterator(),返回的就是迭代器

//使用步骤
    //*(1)使用集合中的方法 iterator()获取迭代器的实现类对象,使用 iterator 接口接收(多态)
    //(2)使用 iterator 接口中的方法 hasNext()来判断还有没有下一个元素
    //(3)使用 iterator 接口中的方法 next()取出集合中的下一个元素

    public static void main(String[] args) {


        //(1)创建一个集合对象
        Collection<String> coll = new ArrayList<>();
        //add 元素
        coll.add("姚明");
        coll.add("科比");
        coll.add("扎姆斯");
        coll.add("本拉登");
        coll.add("特朗破");
        /*
         * 1.使用集合中的方法 iterator()获取迭代器的实现类对象时
         * iterator<E>接口也是有泛型的,迭代器的泛型与集合一致
         *
         * */
//自动补全变量名的快捷键,command+option+v

        //多态  接口                实现类
        Iterator<String> it = coll.iterator();


//        //2.hasNext
//        boolean b = it.hasNext();
//        System.out.println(b);
//        //3.取出元素
//
//        String t = it.next();
//        System.out.println(t);

       while (it.hasNext()){
           System.out.println(it.next());

       }
//for each 循环  遍历目标只能是  集合 & 数组
       for(String str:coll){
           System.out.println(str);
       }

    }
}
