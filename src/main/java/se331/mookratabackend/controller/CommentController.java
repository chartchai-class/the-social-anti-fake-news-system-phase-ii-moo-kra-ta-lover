package se331.mookratabackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import se331.mookratabackend.entity.Comment;
import se331.mookratabackend.service.CommentService;
import se331.mookratabackend.util.LabMapper;

@Controller
@RequiredArgsConstructor
public class CommentController {
    final CommentService commentService;
    @PostMapping("/comments")
    public ResponseEntity<?> addEvent(@RequestBody Comment comment){
        Comment output = commentService.save(comment);
        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDto(output));
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable("id") Long id){
        Comment comment = commentService.getComments(id);
        if (comment == null) {
            return ResponseEntity.notFound().build();
        }
        commentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
