package se331.mookratabackend.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.mookratabackend.entity.News;

public interface NewsDao {
    Page<News> getNews(Integer pageSize, Integer page);
    News getNews(Long id);
    News save(News news);
    Page<News> getNews(String detail, Pageable pageable);
    void delete(Long id);
}
