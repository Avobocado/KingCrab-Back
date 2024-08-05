package org.example.kingcrabback.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.comment.dto.response.CommentResponse;
import org.example.kingcrabback.domain.comment.repository.CommentRepository;
import org.example.kingcrabback.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadComment {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;


    public List<CommentResponse> readALlComment(Long postId) {
         return commentRepository.findAll().stream()
                 .filter(comment -> comment.getPost().getId().equals(postId))
                .map(comment-> new CommentResponse(comment.getUsername(),comment.getNow(),comment.getComment()))
                .toList();
    }
}
