package org.example.kingcrabback.repository;

import org.example.kingcrabback.entity.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
