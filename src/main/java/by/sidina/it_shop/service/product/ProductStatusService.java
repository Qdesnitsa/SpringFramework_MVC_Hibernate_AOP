package by.sidina.it_shop.service.product;

import by.sidina.it_shop.dao.product.ProductStatusBaseDAO;
import by.sidina.it_shop.dao.product.ProductStatusDAO;
import by.sidina.it_shop.entity.product.ProductStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductStatusService implements ProductStatusBaseService<ProductStatus> {
    private final ProductStatusBaseDAO productStatusBaseDAO;

    @Autowired
    public ProductStatusService(@Qualifier("productStatusDAO") ProductStatusBaseDAO productStatusBaseDAO) {
        this.productStatusBaseDAO = productStatusBaseDAO;
    }

    @Override
    public List<ProductStatus> findAll() {
        return productStatusBaseDAO.findAll();
    }

    @Override
    public Optional<ProductStatus> findById(long id) {
        return productStatusBaseDAO.findById(id);
    }

    @Override
    public void add(ProductStatus entity) {
        productStatusBaseDAO.add(entity);
    }

    @Override
    public void edit(ProductStatus entity) {
        productStatusBaseDAO.edit(entity);
    }
}
