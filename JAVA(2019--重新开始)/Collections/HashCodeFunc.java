public class HashCodeFunc {
    /*
    * hashcode
    *    是一个十进制整数,由系统随机给出,是对象的逻辑地址,不是真实物理地址
    *
    *   object 类中 hashcode方法可以获取对象的 hash 值
    *
    * */

    public static void main(String[] args) {
  //hashSetFunc 继承自 object,我们看看他的 hashcode
        HashSetFunc h1=new HashSetFunc();
        HashSetFunc h2=new HashSetFunc();
        System.out.println(h1.hashCode());
        System.out.println(h2.hashCode());

        //字符串类重写了 hashcode 方法
        //巧合,汉字"重地"与"通话"的 hashcode 一致
        System.out.println("重地".hashCode());
        System.out.println("通话".hashCode());
    }
}
