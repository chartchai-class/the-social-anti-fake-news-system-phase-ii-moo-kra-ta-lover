package se331.mookratabackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.mookratabackend.entity.News;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findAll();
    Page<News> findByShortDetailContainingOrFullDetailContaining(String shortDetail, String fullDetail, Pageable pageable);
}
