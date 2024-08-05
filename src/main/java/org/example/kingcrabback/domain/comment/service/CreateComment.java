package org.example.kingcrabback.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.comment.dto.request.CommentRequest;
import org.example.kingcrabback.domain.comment.entity.Comment;
import org.example.kingcrabback.domain.comment.repository.CommentRepository;
import org.example.kingcrabback.domain.post.repository.PostRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateComment {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional
    //save에서는 commentRequest의 Id가 Post의 Id를 뜻한다.
    public void createComment(CommentRequest commentRequest) {
        Comment comment = Comment.builder()
                .comment(commentRequest.getComment())
                .now(LocalDateTime.now())
                .username(SecurityContextHolder.getContext().getAuthentication().getName())
                .post(postRepository.findById(commentRequest.getId()).orElseThrow(()->new RuntimeException("존재하지 않는 PostId입니다.")))
                .count(0)
                .build();
        commentRepository.save(comment);
    }
}
