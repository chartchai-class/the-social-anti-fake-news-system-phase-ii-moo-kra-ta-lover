package se311.mookratabackend.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se311.mookratabackend.entity.News;

public interface NewsDao {
    Page<News> getNews(Integer pageSize, Integer page);
    News getNews(Long id);
    News save(News news);
    Page<News> getNews(String detail, Pageable pageable);
}
