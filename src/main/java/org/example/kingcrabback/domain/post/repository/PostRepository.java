package org.example.kingcrabback.domain.post.repository;

import org.example.kingcrabback.domain.post.entity.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PostRepository extends CrudRepository<Post,Long> {
    Optional<Post> findById(Long aLong);
}
