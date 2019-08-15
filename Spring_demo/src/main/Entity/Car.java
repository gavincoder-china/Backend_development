package Entity;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-15 09:41
 * @description:
 ************************************************************/
public class Car {
    private String brand;
    private Double price;
    private Integer speed;


    @Override
    public String toString() {
        return "Car{" +
               "brand='" + brand + '\'' +
               ", price=" + price +
               ", speed=" + speed +
               '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
}
