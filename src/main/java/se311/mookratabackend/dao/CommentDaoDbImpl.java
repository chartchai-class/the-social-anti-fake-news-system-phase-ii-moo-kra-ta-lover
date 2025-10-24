package se311.mookratabackend.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se311.mookratabackend.entity.Comment;
import se311.mookratabackend.repository.CommentRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class CommentDaoDbImpl implements CommentDao {
    final CommentRepository commentRepository;
    @Override
    public Page<Comment> getComments(Integer pageSize, Integer page) {
        return commentRepository.findAll(PageRequest.of(page-1,pageSize));
    }

    @Override
    public Comment getComments(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}
