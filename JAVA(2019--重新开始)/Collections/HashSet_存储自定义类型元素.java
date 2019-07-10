import java.util.HashSet;

public class HashSet_存储自定义类型元素 {
    //要在 hashset 中存储重复元素,必须重写 hashcode 与 equals 方法 (idea自带方法)
    //因为 hashset 是通过这两个来判断元素是否重复的


    //见 student 类
    //要求:同名同年龄的人,只能存储一次

    public static void main(String[] args) {
        HashSet<Student> set=new HashSet<>();
       Student s1=new Student("gavin",18);
       Student s2=new Student("gavin",18);

set.add(s1);
set.add(s2);
        System.out.println(set);

    }
}
