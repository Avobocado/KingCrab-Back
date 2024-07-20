package org.example.kingcrabback.domain.post.repository;

import org.example.kingcrabback.domain.post.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post,Long> {
}
