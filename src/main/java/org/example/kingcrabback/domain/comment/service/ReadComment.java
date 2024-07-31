package org.example.kingcrabback.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.comment.dto.response.CommentResponse;
import org.example.kingcrabback.domain.comment.entity.Comment;
import org.example.kingcrabback.domain.comment.repository.CommentRepository;
import org.example.kingcrabback.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadComment {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;


    public List<CommentResponse> readALlComment() {
         return commentRepository.findAll().stream()
                .map(comment-> new CommentResponse(comment.getComment(),comment.getNow(),comment.getUsername()))
                .toList();
    }
}
