package org.example.kingcrabback.domain.comment.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.example.kingcrabback.domain.post.entity.Post;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String comment;

    private LocalDateTime now;

    public Comment(String username, Post post) {
        this.username = username;
        this.comment = comment;
        this.post = post;
    }


    public void updateComment(String comment) {
        this.comment = comment;
    }

    @ManyToOne
    private Post post;
}
