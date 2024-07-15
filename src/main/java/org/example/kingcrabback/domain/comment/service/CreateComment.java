package org.example.kingcrabback.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.comment.dto.CommentRequest;
import org.example.kingcrabback.domain.comment.entity.Comment;
import org.example.kingcrabback.domain.comment.repository.CommentRepository;
import org.example.kingcrabback.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateComment {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    //save에서는 commentRequest의 Id가 Post의 Id를 뜻한다.
    public void createComment(CommentRequest commentRequest) {
        Comment comment = new Comment(commentRequest.getComment(),postRepository.findById(commentRequest.getId()).orElseThrow());
        commentRepository.save(comment);
    }
}
