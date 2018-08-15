package com.learn.Enum;
 /**
  * ordinal()  得到其在枚举中的位置
  *
  *
  * */
public enum EnumTest {
    /**
    * @Description：

    * @Param:
    * @Return:  string
    * @Auther: Gavincoder
    * @Date: 2018/8/13
    */
    WAIT_PAY(0,"等待支付","您还需要支付100块"),
    /**
    * @Description：

    * @Param:
    * @Return:
    * @Auther: Gavincoder
    * @Date: 2018/8/13
    */
    PAID(1,"已支付","您已经支付了100块");
    private int orderStatus;
    private String statuString;
    private  String payall;


    /**
    * @Description：  这边设置构造函数为private，并且不给set方法

    * @Param: [orderStatus, statuString]
    * @Return:
    * @Auther: Gavincoder
    * @Date: 2018/8/13
    */
    private  EnumTest(int orderStatus,String statuString,String payall){
        this.orderStatus=orderStatus;
        this.statuString=statuString;
        this.payall=payall;
    }

     public String getPayall() {
         return payall;
     }

     public int getOrderStatus() {
        return orderStatus;
    }



    public String getStatuString() {
        return statuString;
    }


}
