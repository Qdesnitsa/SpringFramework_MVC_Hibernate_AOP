package by.sidina.it_shop.dao.product;

import by.sidina.it_shop.model.product.ProductType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductTypeDAO implements ProductTypeBaseDAO<ProductType, Long> {
    private final SessionFactory sessionFactory;

    public ProductTypeDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<ProductType> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<ProductType> allProductTypes = session.createQuery("FROM ProductType", ProductType.class).getResultList();
        return allProductTypes;
    }

    @Override
    public Optional<ProductType> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        ProductType productType = session.get(ProductType.class, id);
        return Optional.of(productType);
    }

    @Override
    public void addOrUpdate(ProductType entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }
}
