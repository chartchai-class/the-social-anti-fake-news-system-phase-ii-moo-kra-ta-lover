package se331.mookratabackend.entity;

import jakarta.persistence.*;
import lombok.*;
import se331.mookratabackend.security.user.User;

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
    String vote;
    @Column(columnDefinition = "TEXT")
    String comment;
    @ElementCollection
    List<String> imageUrls;
    @ManyToOne
    News news;
    @ManyToOne
    User user;
    private boolean deleted = false;
}
