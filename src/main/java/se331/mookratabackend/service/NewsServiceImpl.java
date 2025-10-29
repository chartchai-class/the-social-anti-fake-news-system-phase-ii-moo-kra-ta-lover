package se331.mookratabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.mookratabackend.dao.NewsDao;
import se331.mookratabackend.entity.News;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService{
    final NewsDao newsDao;

    @Override
    public Page<News> getNews(Integer pageSize, Integer page) {
        return newsDao.getNews(pageSize, page);
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
    public void delete(Long id) {
        newsDao.delete(id);
    }
}
