package se331.mookratabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.mookratabackend.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAll();
}
