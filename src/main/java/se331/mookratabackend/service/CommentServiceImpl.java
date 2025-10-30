package se331.mookratabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se331.mookratabackend.dao.CommentDao;
import se331.mookratabackend.entity.Comment;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    final CommentDao commentDao;

    @Override
    public Page<Comment> getComments(Integer pageSize, Integer page) {
        return commentDao.getComments(pageSize, page);
    }

    @Override
    public List<Comment> getAdminComments() {
        return commentDao.getAdminComments();
    }

    @Override
    public Comment getComments(Long id) {
        return commentDao.getComments(id);
    }

    @Override
    public Comment save(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public void delete(Long id) {
        commentDao.delete(id);
    }
}
