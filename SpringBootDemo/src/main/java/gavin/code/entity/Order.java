package gavin.code.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class Order {
    private Integer oid;

    private Date otime;

    private BigDecimal totalPrice;

    private Integer userId;
    private List<Orderitems> item;
}