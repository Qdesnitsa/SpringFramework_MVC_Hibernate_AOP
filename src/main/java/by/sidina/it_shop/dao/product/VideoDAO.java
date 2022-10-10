package by.sidina.it_shop.dao.product;

import by.sidina.it_shop.model.product.Video;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VideoDAO implements VideoBaseDAO<Video, Long> {
    private final SessionFactory sessionFactory;

    public VideoDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Video> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Video> allVideos = session.createQuery("FROM Video", Video.class).getResultList();
        return allVideos;
    }

    @Override
    public Optional<Video> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Video video = session.get(Video.class, id);
        return Optional.of(video);
    }

    @Override
    public void addOrUpdate(Video entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }

    @Override
    public List<Video> findAllByLanguage(String language) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Video WHERE language = :language").setParameter("language", language);
        List<Video> allVideos = query.getResultList();
        return allVideos;
    }

    @Override
    public List<Video> findAllByStatus(int statusId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Video WHERE product_status_id = :videoStatusId").setParameter("videoStatusId", statusId);
        List<Video> allVideos = query.getResultList();
        return allVideos;
    }
}
