package se331.mookratabackend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.mookratabackend.entity.News;

import java.util.List;

public interface NewsService {
    Page<News> getNews(Integer pageSize, Integer page);
    List<News> getAdminNews();
    News getNew(Long id);
    News save(News news);
    Page<News> getNews(String detail, Pageable pageable);
    void delete(Long id);
}
