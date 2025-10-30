package se331.mookratabackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.mookratabackend.entity.Comment;
import se331.mookratabackend.entity.News;
import se331.mookratabackend.service.CommentService;
import se331.mookratabackend.util.LabMapper;

import java.util.List;

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
        if (comment != null) {
            comment.setDeleted(true);
            commentService.save(comment);
            return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDto(comment));
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @GetMapping("/admin/comments")
    public ResponseEntity<?> getEventLists(){
        List<Comment> output = commentService.getAdminComments();
        if( output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDto(output));
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Comments found");
        }
    }
}
