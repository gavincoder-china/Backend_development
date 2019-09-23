package gavin.code.dto;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class Order {
    private Integer oid;

    private Date otime;

    private BigDecimal totalPrice;

    private Integer userId;
}