package org.example.kingcrabback.domain.post.repository;

import org.example.kingcrabback.domain.post.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
}
