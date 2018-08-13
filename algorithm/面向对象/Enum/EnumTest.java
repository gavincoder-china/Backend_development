package 面向对象.Enum;

public enum EnumTest {
    /**
    * @Description：

    * @Param:
    * @Return:  string
    * @Auther: Gavincoder
    * @Date: 2018/8/13
    */
    WAIT_PAY(0,"等待支付"),
    /**
    * @Description：

    * @Param:
    * @Return:
    * @Auther: Gavincoder
    * @Date: 2018/8/13
    */
    PAID(1,"已支付");
    private int orderStatus;
    private String statuString;


    /**
    * @Description：  这边设置构造函数为private，并且不给set方法

    * @Param: [orderStatus, statuString]
    * @Return:
    * @Auther: Gavincoder
    * @Date: 2018/8/13
    */
    private  EnumTest(int orderStatus,String statuString){
        this.orderStatus=orderStatus;
        this.statuString=statuString;
    }

    public int getOrderStatus() {
        return orderStatus;
    }



    public String getStatuString() {
        return statuString;
    }


}
