package org.example.kingcrabback.domain.comment.like.repository;

import org.example.kingcrabback.domain.comment.entity.Comment;
import org.example.kingcrabback.domain.comment.like.entity.CommentLike;
import org.example.kingcrabback.domain.post.entity.Post;
import org.example.kingcrabback.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {
    Optional<CommentLike> findByUserAndComment(User user, Comment comment);
    boolean existsByUserAndComment(User user, Comment comment);
    void deleteByUserAndComment(User user, Comment comment);
}
