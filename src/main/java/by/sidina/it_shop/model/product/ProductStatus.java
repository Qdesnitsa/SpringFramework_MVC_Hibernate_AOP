package by.sidina.it_shop.model.product;

import by.sidina.it_shop.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product_status")
public class ProductStatus extends AbstractEntity {
    @Column(name = "status")
    private String productStatus;

    public ProductStatus() {
    }

    public ProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public String toString() {
        return productStatus;
    }
}
