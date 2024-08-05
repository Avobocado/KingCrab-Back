package org.example.kingcrabback.domain.comment.entity;

import lombok.*;
import org.example.kingcrabback.domain.post.entity.Post;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String comment;

    private LocalDateTime now;

    @Column(columnDefinition = "INT")
    private Integer count = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    public void updateComment(String comment) {
        this.comment = comment;
    }

    public void addLike() {
        this.count += 1;
    }

    public void minusLike() {
        this.count -= 1;
    }
}
