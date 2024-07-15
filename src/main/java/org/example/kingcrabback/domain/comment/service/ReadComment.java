package org.example.kingcrabback.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.comment.entity.Comment;
import org.example.kingcrabback.domain.comment.repository.CommentRepository;
import org.example.kingcrabback.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReadComment {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;


    public Comment readComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        return comment;
    }
}