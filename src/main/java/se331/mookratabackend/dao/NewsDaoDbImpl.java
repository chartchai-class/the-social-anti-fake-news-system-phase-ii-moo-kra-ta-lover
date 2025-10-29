package se331.mookratabackend.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.mookratabackend.entity.News;
import se331.mookratabackend.repository.NewsRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class NewsDaoDbImpl implements NewsDao {
    final NewsRepository newsRepository;
    @Override
    public Page<News> getNews(Integer pageSize, Integer page) {
        return newsRepository.findAll(PageRequest.of(page-1,pageSize));
    }

    @Override
    public News getNews(Long id) {
        return newsRepository.findById(id).orElse(null);
    }

    @Override
    public News save(News news) {
        return newsRepository.save(news);
    }

    @Override
    public Page<News> getNews(String detail, Pageable pageable) {
        return newsRepository.findByShortDetailContainingOrFullDetailContaining(detail, detail, pageable);
    }

    @Override
    public void delete(Long id) {
        newsRepository.deleteById(id);
    }
}
