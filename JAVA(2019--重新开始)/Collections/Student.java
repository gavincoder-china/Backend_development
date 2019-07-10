import java.util.Objects;

public class Student implements Comparable<Student> {

    private String name;
    private int age;

    public Student() {

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
               "name='" + name + '\'' +
               ", age=" + age +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
               Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    //重写排序的规则
    @Override
    public int compareTo(Student o) {

        //return 0; 认为元素都是相同的

        //自定义规则,比较两个人的年龄
        return this.getAge()-o.getAge();
        //升序  this 指的是调用的那个对象  o 指的是传入的参数对象
        //this-参数 升序
        //参数-this 降序
    }
}
