package org.example.kingcrabback.domain.post.like.repository;

import org.example.kingcrabback.domain.post.like.entity.PostLike;
import org.example.kingcrabback.domain.user.entity.User;
import org.example.kingcrabback.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    Optional<PostLike> findByUserAndPost(User user, Post post);
}