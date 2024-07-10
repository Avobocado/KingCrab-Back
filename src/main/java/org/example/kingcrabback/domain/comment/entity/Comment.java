package org.example.kingcrabback.domain.comment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.kingcrabback.domain.post.entity.Post;

@Entity
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String comment;

    public Comment(String comment, Post post) {
        this.comment = comment;
        this.post = post;
    }


    public void updateComment(String comment) {
        this.comment = comment;
    }

    @ManyToOne
    private Post post;
}
