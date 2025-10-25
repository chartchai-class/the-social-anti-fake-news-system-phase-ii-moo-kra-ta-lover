package se331.mookratabackend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.mookratabackend.entity.News;

public interface NewsService {
    Page<News> getNews(Integer pageSize, Integer page);
    News getNew(Long id);
    News save(News news);
    Page<News> getNews(String detail, Pageable pageable);
}
