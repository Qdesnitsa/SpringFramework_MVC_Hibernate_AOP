package by.sidina.it_shop.service.product;

import by.sidina.it_shop.dao.product.ProductTypeBaseDAO;
import by.sidina.it_shop.dao.product.ProductTypeDAO;
import by.sidina.it_shop.entity.product.ProductType;
import by.sidina.it_shop.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductTypeService implements BaseService<ProductType> {
    private final ProductTypeBaseDAO productTypeBaseDAO;

    @Autowired
    public ProductTypeService(@Qualifier("productTypeDAO") ProductTypeBaseDAO productTypeBaseDAO) {
        this.productTypeBaseDAO = productTypeBaseDAO;
    }

    @Override
    public List<ProductType> findAll() {
        return productTypeBaseDAO.findAll();
    }

    @Override
    public Optional<ProductType> findById(long id) {
        return productTypeBaseDAO.findById(id);
    }

    @Override
    public void add(ProductType entity) {
        productTypeBaseDAO.add(entity);
    }

    @Override
    public void edit(ProductType entity) {
        productTypeBaseDAO.edit(entity);
    }
}
