package org.example.kingcrabback.domain.comment.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.comment.dto.CommentRequest;
import org.example.kingcrabback.domain.comment.entity.Comment;
import org.example.kingcrabback.domain.comment.repository.CommentRepository;
import org.example.kingcrabback.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateComment {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    //update에서는 commentRequest의 Id가 Comment의 Id를 뜻한다.
    @Transactional
    public void updateComment(CommentRequest commentRequest){
        Comment comment = commentRepository.findById(commentRequest.getId()).orElseThrow();
        comment.updateComment(commentRequest.getComment());
    }



}
