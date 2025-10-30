package se331.mookratabackend.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.mookratabackend.entity.Comment;
import se331.mookratabackend.repository.CommentRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class CommentDaoDbImpl implements CommentDao {
    final CommentRepository commentRepository;
    @Override
    public Page<Comment> getComments(Integer pageSize, Integer page) {
        return commentRepository.findByDeletedFalse(PageRequest.of(page-1,pageSize));
    }

    @Override
    public List<Comment> getAdminComments() {
        return commentRepository.findByDeletedTrue();
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
