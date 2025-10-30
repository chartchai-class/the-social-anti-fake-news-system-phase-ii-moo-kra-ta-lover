package se331.mookratabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se331.mookratabackend.dao.NewsDao;
import se331.mookratabackend.entity.News;
import se331.mookratabackend.repository.CommentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService{
    final NewsDao newsDao;
    final CommentRepository commentRepository;

    @Override
    public Page<News> getNews(Integer pageSize, Integer page) {
        return newsDao.getNews(pageSize, page);
    }

    @Override
    public List<News> getAdminNews() {
        return newsDao.getAdminNews();
    }

    @Override
    public News getNew(Long id) {
        return newsDao.getNews(id);
    }

    @Override
    public News save(News news) {
        return newsDao.save(news);
    }

    @Override
    public Page<News> getNews(String detail, Pageable pageable) {
        return newsDao.getNews(detail, pageable);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        // First delete all comments for this news
        commentRepository.deleteByNewsId(id);
        // Then delete the news
        newsDao.delete(id);
    }
}
