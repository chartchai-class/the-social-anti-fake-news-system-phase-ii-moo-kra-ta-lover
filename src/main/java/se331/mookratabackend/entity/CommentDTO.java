package se331.mookratabackend.entity;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    Long id;
    String user;
    String vote;
    String comment;
    List<String> imageUrls;
    CommentNewsDTO news;
}
