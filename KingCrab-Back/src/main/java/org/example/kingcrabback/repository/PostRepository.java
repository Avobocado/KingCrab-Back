package org.example.kingcrabback.repository;

import org.example.kingcrabback.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
}
