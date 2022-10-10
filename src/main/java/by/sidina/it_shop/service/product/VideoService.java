package by.sidina.it_shop.service.product;

import by.sidina.it_shop.dao.product.VideoBaseDAO;
import by.sidina.it_shop.model.product.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class VideoService implements VideoBaseService<Video> {
    private final VideoBaseDAO videoBaseDAO;

    @Autowired
    public VideoService(@Qualifier("videoDAO") VideoBaseDAO videoBaseDAO) {
        this.videoBaseDAO = videoBaseDAO;
    }

    @Override
    public List<Video> findAll() {
        return videoBaseDAO.findAll();
    }

    @Override
    public Optional<Video> findById(long id) {
        return videoBaseDAO.findById(id);
    }

    @Transactional
    @Override
    public void add(Video entity) {
        videoBaseDAO.addOrUpdate(entity);
    }

    @Override
    public List<Video> findAllByLanguage(String language) {
        return videoBaseDAO.findAllByLanguage(language);
    }

    @Override
    public List<Video> findAllByStatus(int statusId) {
        return videoBaseDAO.findAllByStatus(statusId);
    }
}
