package se311.mookratabackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String user;
    String vote;
    String comment;
    @ElementCollection
    List<String> imageUrls;
    @ManyToOne
    News news;
}
