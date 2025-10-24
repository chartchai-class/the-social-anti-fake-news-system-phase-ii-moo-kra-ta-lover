package se311.mookratabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se311.mookratabackend.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAll();
}
