package jdk8.stream;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest13 {

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 100, 20);
        Student student2 = new Student("lisi", 90, 20);
        Student student3 = new Student("wangwu", 90, 30);
        Student student4 = new Student("zhangsan", 80, 40);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

//        Map<String, List<Student>> map = students.stream().
//                collect(Collectors.groupingBy(Student::getName));
//        Map<Integer, List<Student>> map = students.stream().
//                collect(Collectors.groupingBy(Student::getScore));

//        Map<String, Long> map = students.stream().
//                collect(Collectors.groupingBy(Student::getName, Collectors.counting()));

//        Map<String, Double> map = students.stream().
//                collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));

        Map<Boolean, List<Student>> map = students.stream().
                collect(Collectors.partitioningBy(student -> student.getScore() >= 90));


        System.out.println(map);


    }
}
