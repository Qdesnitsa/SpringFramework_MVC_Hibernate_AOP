package by.sidina.it_shop.entity.product;

import by.sidina.it_shop.entity.EntityAbstract;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product_type")
public class ProductType extends EntityAbstract {
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
