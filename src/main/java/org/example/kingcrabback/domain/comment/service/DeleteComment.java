package org.example.kingcrabback.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.comment.entity.Comment;
import org.example.kingcrabback.domain.comment.exception.CommentNotFoundException;
import org.example.kingcrabback.domain.comment.repository.CommentRepository;
import org.example.kingcrabback.domain.post.repository.PostRepository;
import org.example.kingcrabback.domain.user.exception.UserMissMatchException;
import org.example.kingcrabback.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteComment {

    private final CommentRepository commentRepository;
    private final UserFacade userFacade;
    private final PostRepository postRepository;

    @Transactional
    public void deleteComment(Long commentId) {
            Comment comment = commentRepository.findById(commentId).orElseThrow(() -> CommentNotFoundException.EXCEPTION);
        if(userFacade.getCurrentUser().getUserName().equals(comment.getUsername())){
            commentRepository.delete(comment);
            postRepository.findById(comment.getPost().getId()).orElseThrow(()-> new RuntimeException("")).removeComment();
        }else{
            throw UserMissMatchException.EXCEPTION;
        }
    }

}
