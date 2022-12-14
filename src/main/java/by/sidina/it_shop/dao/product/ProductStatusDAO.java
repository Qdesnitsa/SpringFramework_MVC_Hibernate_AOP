package by.sidina.it_shop.dao.product;

import by.sidina.it_shop.model.product.ProductStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductStatusDAO implements ProductStatusBaseDAO<ProductStatus, Long> {
    private final SessionFactory sessionFactory;

    public ProductStatusDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<ProductStatus> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<ProductStatus> allProductStatuses = session.createQuery("FROM ProductStatus", ProductStatus.class).getResultList();
        return allProductStatuses;
    }

    @Override
    public Optional<ProductStatus> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        ProductStatus productStatus = session.get(ProductStatus.class, id);
        return Optional.of(productStatus);
    }

    @Override
    public void addOrUpdate(ProductStatus entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }
}
