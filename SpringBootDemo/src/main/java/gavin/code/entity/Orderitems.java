package gavin.code.entity;

import lombok.Data;

import java.util.List;

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


    private List<Products> products;
}