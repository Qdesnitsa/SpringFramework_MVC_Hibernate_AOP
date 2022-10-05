package by.sidina.it_shop.dao.product;

import by.sidina.it_shop.entity.product.ProductType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductTypeDAO implements ProductTypeBaseDAO<ProductType> {
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
    public Optional<ProductType> findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        ProductType productType = session.get(ProductType.class, id);
        return Optional.of(productType);
    }

    @Override
    public void add(ProductType entity) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(entity);
    }

    @Override
    public void edit(ProductType entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }
}
