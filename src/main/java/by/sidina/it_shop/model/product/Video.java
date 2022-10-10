package by.sidina.it_shop.model.product;

import by.sidina.it_shop.model.user.User;
import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("2")
public class Video extends AbstractProduct {
    @NotNull
    @Column(name = "length_hours")
    private double lengthHours;

    public Video() {
    }

    public Video(String name, String language, String author, BigDecimal price, ProductStatus productStatus, User user, double lengthHours) {
        super(name, language, author, price, productStatus, user);
        this.lengthHours = lengthHours;
    }

    public double getLengthHours() {
        return lengthHours;
    }

    public void setLengthHours(double lengthHours) {
        this.lengthHours = lengthHours;
    }

    public int getProductType() {
        return 2;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                super.toString() +
                ", lengthHours=" + lengthHours +
                "; ";
    }
}
