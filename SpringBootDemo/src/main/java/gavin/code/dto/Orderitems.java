package gavin.code.dto;

import lombok.Data;

@Data
public class Orderitems {
    /**
    * id
    */
    private Integer id;

    /**
    * 订单编号
    */
    private Integer oid;

    /**
    * 商品编号
    */
    private Integer pid;

    /**
    * 下单数量
    */
    private Integer amount;
}