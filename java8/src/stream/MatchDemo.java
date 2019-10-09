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
 * @Date : 2019-10-08 15:53
 * @description:
 ************************************************************/
public class MatchDemo {

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


        //   有一个满足      anyMatch：Stream 中任意一个元素符合传入的 predicate，返回 true
        Boolean anyMatch = students.stream().anyMatch(s -> "南京".equals(s.getAddress()));
        if (!anyMatch) {
            System.out.println("没有南京人");
        }

        //    全部满足       allMatch：Stream 中全部元素符合传入的 predicate，返回 true
        Boolean allMatch = students.stream().allMatch(s -> s.getAge() >= 15);
        if (allMatch) {
            System.out.println("所有学生都满15周岁");
        }

        //    没有一个满足     noneMatch：Stream 中没有一个元素符合传入的 predicate，返回 true
        Boolean noneMatch = students.stream().noneMatch(s -> "王八".equals(s.getName()));
        if (noneMatch) {
            System.out.println("没有叫王八的同学");
        }

    }
}
