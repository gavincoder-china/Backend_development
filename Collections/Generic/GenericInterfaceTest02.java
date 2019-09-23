package Generic;

public class GenericInterfaceTest02<I> implements Generic.GenericInterface<I> {
    //泛型接口实现方法 02
    //泛型跟着接口走
    //把类型的确定放在创建对象的时刻

    @Override
    public void show(I i) {
        System.out.println(i);
    }


}
