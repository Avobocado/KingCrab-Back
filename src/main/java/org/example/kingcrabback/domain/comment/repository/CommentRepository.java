package org.example.kingcrabback.domain.comment.repository;

import org.example.kingcrabback.domain.comment.entity.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
