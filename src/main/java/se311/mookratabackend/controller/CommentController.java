package se311.mookratabackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import se311.mookratabackend.entity.Comment;
import se311.mookratabackend.service.CommentService;
import se311.mookratabackend.util.LabMapper;

@Controller
@RequiredArgsConstructor
public class CommentController {
    final CommentService commentService;
    @PostMapping("/news")
    public ResponseEntity<?> addEvent(@RequestBody Comment comment){
        Comment output = commentService.save(comment);
        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDto(output));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteEvent(@RequestBody Comment comment){
        Comment output = commentService.
    }
}
