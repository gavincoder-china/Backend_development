import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class collectionFunc {
    //java.util.Collection接口
// 所有单列集合的最顶层接口,定义了所有单列集合共性的方法
// 任意的单列集合都可以使用 collection 接口中的方法
    public static void main(String[] args) {
        //创建集合对象,可以使用多态
        ArrayList<String> coll = new ArrayList<>();
        System.out.println(coll);  //重写了 tostring方法 []

        //(1)添加元素,返回是 bool,一般返回 true ,可以不接收
        coll.add("gavin");
        coll.add("张三");
        coll.add("李四");
        coll.add("王五");
        coll.add("赵六");
        coll.add("田七");
        System.out.println(coll);

        //添加多个元素  静态方法!!!
        Collections.addAll(coll, "a", "b", "c", "d");

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

        //(6)toArray把集合变成数组,集合的泛型是 object
        Object[] arr = coll.toArray();
        for (Object x : arr
        ) {
            System.out.println(x);
        }

        //(7)shuffle  打乱集合内元素顺序  静态方法
        Collections.shuffle((List<?>) coll);
        System.out.println(coll);

        //(8)sort 默认升序排序  只能排 list


        Collections.sort(coll);
        System.out.println(coll);
        //(9)对自定义类型进行排序  使用的是 Student 类
        //被排序的集合里面存储的元素必须重写 comparable 接口,定义排序规则
        ArrayList<Student> stu = new ArrayList<>();

        Collections.addAll(stu, (new Student("gavin", 20)),
                           (new Student("betty", 19)),
                           (new Student("myra", 18)),
                           (new Student("gavin", 18))
                          );
        System.out.println(stu);
        Collections.sort(stu);
        System.out.println(stu);

        //(10)sort  通过实现Comparator接口 来进行排序自定义
        Collections.sort(stu, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getAge() - o1.getAge();  //降序排序
            }
        });
        System.out.println(stu);
        //多规则比较

        Collections.sort(stu, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //如果两个人年龄一样,则按照姓名的首字母升序排序
                int result = o2.getAge() - o1.getAge();  //降序排序
                if (result == 0)//这表示两人年龄一致
                {
                    result = o1.getName().charAt(0) - o2.getName().charAt(0);//升序排序
                }
                return result;
            }
        });
        System.out.println(stu);

        //(11)clear 清空集合里所有元素,但是集合还存在
        coll.clear();
        System.out.println(coll);
        System.out.println(coll.isEmpty());


    }

}
