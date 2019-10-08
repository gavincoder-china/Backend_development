package stream;

import java.util.ArrayList;
import java.util.List;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-08 16:03
 * @description:
 ************************************************************/
public class SumDemo {


    public static void main(String[] args) {


        Student s1 = new Student(1L, "张三", 15, "浙江");
        Student s2 = new Student(2L, "李四", 15, "湖北");
        Student s3 = new Student(3L, "王五", 17, "北京");
        Student s4 = new Student(4L, "田七", 17, "浙江");
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

       //求所有学生的年龄和
        int sum = students.stream().mapToInt(stu -> stu.getAge()).sum();
        System.out.println(sum);


    }
}
