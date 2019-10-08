package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-08 15:57
 * @description:
 ************************************************************/
public class MinMaxDemo {

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

        //min 求最小值
        Student student = students.stream().min(Comparator.comparingInt(Student::getAge)).get();

        //    传统写法    Student minS = students.stream().min((stu1,stu2) ->Integer.compare(stu1.getAge(),stu2.getAge())).get();
        System.out.println(student);

        //max  求最大值
        Student student2 = students.stream().max(Comparator.comparingInt(Student::getAge)).get();
        System.out.println(student2);
    }
}
