package Generic;

public class GenericClassTest {
    public static void main(String[] args) {

        GenericClass<Integer> gc = new GenericClass<>();
        gc.setName(123);

        int name = gc.getName();
        System.out.println(name);

    }

}
