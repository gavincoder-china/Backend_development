package Generic;

public class GenericClass<e> {
    //泛型类
//如果给他写定数据类型为 string,则在后面调用会不方便,则写成 E
 /*   private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;e
    }*/
    private e name;

    public e getName() {
        return name;
    }

    public void setName(e name) {
        this.name = name;
    }
}
