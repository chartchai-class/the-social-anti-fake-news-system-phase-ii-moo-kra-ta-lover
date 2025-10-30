package se331.mookratabackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import se331.mookratabackend.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAll();

    Page<Comment> findByDeletedFalse(Pageable pageable);

    List<Comment> findByDeletedTrue();


    @Modifying
    @Query("DELETE FROM Comment c WHERE c.news.id = :newsId")
    void deleteByNewsId(Long newsId);
}
