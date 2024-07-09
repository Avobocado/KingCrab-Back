package org.example.kingcrabback.domain.comment.entity;

import jakarta.persistence.*;
import org.example.kingcrabback.domain.post.entity.Post;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String comment;

    @ManyToOne
    private Post post;
}
