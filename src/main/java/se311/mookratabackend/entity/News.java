package se311.mookratabackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String topic;
    String shortDetail;
    String fullDetail;
    String reporter;
    String reportDate;
    String imageUrl;
    @OneToMany(mappedBy = "news")
    @Builder.Default
    List<Comment> comments = new ArrayList<>();
}
