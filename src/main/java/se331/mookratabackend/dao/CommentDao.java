package se331.mookratabackend.dao;

import org.springframework.data.domain.Page;
import se331.mookratabackend.entity.Comment;

public interface CommentDao {
    Page<Comment> getComments(Integer pageSize, Integer page);
    Comment getComments(Long id);
    Comment save(Comment comment);
    void delete(Long id);
}
