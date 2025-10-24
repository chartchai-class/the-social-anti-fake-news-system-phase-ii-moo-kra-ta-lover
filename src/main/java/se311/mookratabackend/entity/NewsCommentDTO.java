package se311.mookratabackend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsCommentDTO {
    Long id;
    String user;
    String vote;
    String comment;
    List<String> imageUrls;
}
