package by.sidina.it_shop.model.product;

import by.sidina.it_shop.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product_type")
public class ProductType extends AbstractEntity {
    @Column(name = "type")
    private String productType;

    public ProductType() {
    }

    public ProductType(String productType) {
        this.productType = productType;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
