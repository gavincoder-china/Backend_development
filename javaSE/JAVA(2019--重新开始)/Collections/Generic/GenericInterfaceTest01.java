package Generic;

public class GenericInterfaceTest01 implements GenericInterface<String>{

    //泛型接口  实现方式 01

    @Override
    public void show(String s) {
        System.out.println(s);
    }


}
