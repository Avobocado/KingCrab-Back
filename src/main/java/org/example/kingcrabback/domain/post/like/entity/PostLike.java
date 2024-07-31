package org.example.kingcrabback.domain.post.like.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.kingcrabback.domain.post.entity.Post;
import org.example.kingcrabback.domain.user.entity.User;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;
}
