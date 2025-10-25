package se331.mookratabackend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsDTO {
    Long id;
    String topic;
    String shortDetail;
    String fullDetail;
    String reporter;
    String reportDate;
    String imageUrl;
    List<NewsCommentDTO> comments = new ArrayList<>();
}
