package se311.mookratabackend.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentNewsDTO {
    Long id;
    String topic;
    String shortDetail;
    String fullDetail;
    String reporter;
    String reportDate;
    String imageUrl;
}
