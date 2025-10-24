package se311.mookratabackend.dao;

import org.springframework.data.domain.Page;
import se311.mookratabackend.entity.Comment;
import se311.mookratabackend.entity.News;

public interface CommentDao {
    Page<Comment> getComments(Integer pageSize, Integer page);
    Comment getComments(Long id);
    Comment save(Comment comment);
    void delete(Long id);
}
