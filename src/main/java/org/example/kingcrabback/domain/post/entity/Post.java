package org.example.kingcrabback.domain.post.entity;

import jakarta.persistence.*;
import org.example.kingcrabback.domain.comment.entity.Comment;

import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> commentList;
}
