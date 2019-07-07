#java精华笔记  
## 方法调用语句      
>调用一个类的对象的方法：  
类名（或对象名）.方法名（参数列表）  
----------------
##输入方法  
>Scanner scan=new Scanner(System.in);  
int a=scan.nextInt(); //输入整型          
String b=scan.next(); // 输入字符串         

-------------
##随机数  
>Math.random()  
如果Math.random*8，就是取0-7之间的数，再加上一，取1-8之间的数  
同理可得其余取值范围 
 

-----------------------
##idea快捷代码生成  
>1、System.out.println()      
     输入sout，按下enter键，生成System.out.println()方法.  
     sout--->soutv=System.out.println("变量名 = " + 变量)   
     soutp--->System.out.println("")     
2、public static void main(String [] args){}     
     输入psvm，按下enter键，生成main方法.    
3、for(int i=0;i<;i++){}    
     输入fori，按下enter键，生成for循环.      
4、for(Object o: ){}       
     输入iter，按下enter键，生成foreach循环.   
 ##判断字符串是否相等  
 >String a=new String("aaa");     
 String b=new String("aaa");    
 boolean flag=(a.equals(b));    
 如果直接用==判断，则会判断变量地址  
 ##三目运算符  
 >基础代码  
 if(a<b)    
     　　 min=a;  
  else   
     　　 min=b;   
  三目运算符   
  min=(a<b)?a:b; 
           
##CamelCase Idea插件    
 >将不是驼峰格式的名称，快速转成驼峰格式，  
 安装好后，选中要修改的名称，按快捷键shift+alt+u。      
 ##iBATIS/MyBatis plugin      
 >轻松通过快捷键找到MyBatis中对应的Mapper和XML，CTRL+ALT+B  
 ##alibaba 插件
 >alt+enter
 ##用mybatis-plus插件一键生成代码
 >  从实体类到comtroller全部生成/alt  + insert
 ##java八种基本数据类型  
 >java四类八种基本数据类型
  第一类：整型 byte(8位) short（16位） int（32位） long（64位）     
  第二类：浮点型 float（32位，全部字符只有8，小数点最后一位进一法） double（64位）         
  第三类：逻辑型 boolean(它只有两个值可取true false)（1位，1/8字节）      
  第四类：字符型 char（16位）（2字节）      
  BigDecimal //不会丢失任何精度    
  ##api文档查找插件   
  >这个东西是插件配合软件使用  
  插件dash               
  软件zeal             
  快捷键 ctrl+shift+d      
  ##There is no default constructor available in 'Pet
  >前提：继承ArrayAdapter的时候，子类出现该错误。创建构造函数依旧出错。   
   ==》原因：ArrayAdapter没有无参构造函数，所以子类继承时，  
   构造函数中必须显式调用父类构造方法，并且传递对应所需要的参数。   
   构造函数，当写了有参构造函数的时候，一定要加上再次无参构造函数。  
   ##protected
  >在不同包，但是具有继承关系的类中可以访问  
  ##在方法里不能定义static常量  
  ##JAVA子类继承父类，一定要在构造方法中继承有SUPER？
  >如果父类中有无参的构造方法，可以不继承，默认继承无参构造方法！  
   如果父类中都是有参构造方法就需要，super去继承了     
    Fulei(int a) {    
   this.a = a;      
   }        
   子类      
   Zilei(int a) {     
   super(a);     
   }         
   ##继承抽象类的子类，必须重写抽象方法  
   >抽象方法没有方法体。就是没有花括号  
   抽象类和普通类一样，有构造函数。抽象类中有一些属性，可以利用构造方法对属性进行初始化。
   子类对象实例化的时候先执行抽象类的构造，再执行子类构造。            
   抽象类不能用final声明。因为抽象类必须有子类继承，所以抽象类不能使用final定义。   
   抽象类不能用static进行声明，但是抽象类中的内部类可以使用static声明。    
   ##toSTring()返回对象的有关信息
   >Object 类提供的toString方法总是返回该对象实现类的类名 + @ +hashCode值。    
   ##判断对象是否为某对象  
   >if(pet instanceof Dog)  
   用instanceof运算符  
   对象  instanceof  类或接口	
   ##基本数据类型及其封装类  
   >八种基本数据类型分别是：int、short、float、double、long、boolean、byte、char；    
  它们的封装类分别是：Integer、Short、Float、Double、Long、Boolean、Byte、Character。
   ##equals的源码分析  
   > public boolean equals(Object anObject) {     
            if (this == anObject) {     
                return true;       
            }         
            if (anObject instanceof String) {       
                String aString = (String)anObject;    
                if (coder() == aString.coder()) {    
                    return isLatin1() ? StringLatin1.equals(value, aString.value)   
                                      : StringUTF16.equals(value, aString.value);   
                }          
            }          
            return false;      
        }        
    ##封装数据类型的作用
    >封装类型就是java面向对象引入的数据类型，里面定义了一些常用的方法，是用new分配到堆内存上的。引入封装类型的主要目的是因为类能够提供必要的方法，    
    用于实现基本数据类型的数值与可打印字符串之间的转换，以及一些其他的实用程序方法。Java为每个原始类型提供了封装类。     
     1 、Boolean VS boolean    
     public final class Boolean extends Object implementsSerializable,Comparable      
     Boolean 类将基本类型为boolean的值包装在一个对象中。一个Boolean类型的对象只包含一个类型为boolean的字段。  
     此外，此类还为boolean和String的相互转换提供了许多方法，并提供了处理 boolean时非常有用的其他一些常量和方法。   
     2、 Byte VS byte  
     public final class Byte extends Number implements Comparable Byte类将基本类型      
     byte的值包装在一个对象中。一个Byte类型的对象只包含一个类型为 byte的字段。此外，该类还为 byte和 String的相互转换提供了几种方法，并提供了处理 byte时非常有用的其他一些常量和方法。    
     3、 Character VS char      
     public final class Character extends Object implements Serializable, Comparable   
     Character类在对象中包装一个基本类型char的值。    
     Character类型的对象包含类型为char的单个字段。此外，该类提供了几种方法，以确定字符的类别（小写字母，数字，等等），并将字符从大写转换成小写，反之亦然。    
     4 、Double VS double      
     public final class Double extends Number implements Comparable Double类在对象中包装了一个基本类型double的值。   
     每个Double类型的对象都包含一个double类型的字段。此外，该类还提供了多个方法，可以将double转换为String，将String转换为double，还提供了其他一些处理double时有用的常量和方法。   
     5、 Float VS float        
     public final class Float extends Number implements Comparable      
     Float类在对象中包装了一个float基本类型的值。Float类型的对象包含一个float类型的字段。     
     此外，此类提供了几种方法，可在float类型和String类型之间互相转换，并且还提供了处理float类型时非常有用的其他一些常量和方法。  
     6、 Integer VS int      
     public final class Integer extends Number implements Comparable      
     Integer类在对象中包装了一个基本类型int的值。Integer类型的对象包含一个int类型的字段。    
     此外，该类提供了多个方法，能在int类型和String类型之间互相转换，还提供了处理int类型时非常有用的其他一些常量和方法。    
     7 Long VS long               
     public final class Long extends Number implements Comparable      
     Long类在对象中封装了基本类型long的值。每个Long类型的对象都包含一个long类型的字段。      
     此外，该类提供了多个方法，可以将long转换为String，将String转换为long，除此之外，还提供了其他一些处理long时有用的常量和方法。    
     8、 Short VS short         
     public final class Short extends Number implements Comparable           
     Short类在对象中包装基本类型short的值。一个Short类型的对象只包含一个short类型的字段。     
     另外，该类提供了多个方法，可以将short转换为String，将String转换为short，同时还提供了其他一些处理short时有用的常量和方法。  
     9、public final class Voidextends Object       
     Void 类是一个不可实例化的占位符类，它保持一个对代表 Java 关键字 void 的 Class 对象的引用。      
     类的对象才能为null，不能把null赋值给一个变量不能，如int m=null;但可以String s=null;因为String是个类。    

#Math方法
 > Math.round() 函数返回一个数字四舍五入后最接近的整数。最难掌握的是round方法，他表示“四舍五入”，算法为Math.floor(x+0.5),即将原来的数字加上0.5后再向下取整，所以，Math.round(11.5)的结果是12，Math.round(-11.5)的结果为-11.    
 > floor 返回不大于的最大整数   
round 则是4舍5入的计算，入的时候是到大于它的整数  
round方法，它表示“四舍五入”，算法为Math.floor(x+0.5)，即将原来的数字加上0.5后再向下取整，所以，Math.round(11.5)的结果为12，Math.round(-11.5)的结果为-11。  
ceil 则是不小于他的最小整数  
#堆栈等  
>堆区：只存放类对象，线程共享；  
方法区：又叫静态存储区，存放class文件和静态数据，线程共享;  
栈区：存放方法局部变量，基本类型变量区、执行环境上下文、操作指令区，线程不共享;  
![](https://raw.githubusercontent.com/xunyegege/picgo_repo/master/G%3A%5Cgithub%5Cpicgo_repo20180909170628.png)  


#idea中抽取代码，按快捷键Ctrl + Alt + M  



#Java容器
>ArrayList 数组实现，查询速度很快，但是加东西，速度很慢。线程不安全，效率高。  
>LinkedList 链表是吸纳，增减速度很快，但是查询速度很慢。线程不安全，效率高。   
>vertor 向量，数组实现，线程安全，效率低。  
>


#java 进程&线程  
![](https://raw.githubusercontent.com/xunyegege/picgo_repo/master/G%3A%5Cgithub%5Cpicgo_repo20180919195048.png)