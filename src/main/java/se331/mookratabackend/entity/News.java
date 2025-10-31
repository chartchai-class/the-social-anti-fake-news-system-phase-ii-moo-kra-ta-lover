package se331.mookratabackend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;
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
    @Column(columnDefinition = "TEXT")
    String shortDetail;
    @Column(columnDefinition = "TEXT")
    String fullDetail;
    String reporter;
    String reportDate;
    String imageUrl;
    @OneToMany(mappedBy = "news")
    @Builder.Default
    @SQLRestriction("deleted = false")
    List<Comment> comments = new ArrayList<>();

    private boolean deleted = false;
}
