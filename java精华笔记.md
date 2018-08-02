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
##辅助函数  
>less() //对元素进行比较  
 exch()  //将元素交换位置  
            
##CamelCase     
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