package org.example.kingcrabback.domain.comment.like.service;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.comment.entity.Comment;
import org.example.kingcrabback.domain.comment.like.dto.CommentLikeRequest;
import org.example.kingcrabback.domain.comment.like.dto.CommentLikeResponse;
import org.example.kingcrabback.domain.comment.like.entity.CommentLike;
import org.example.kingcrabback.domain.comment.like.repository.CommentLikeRepository;
import org.example.kingcrabback.domain.post.entity.Post;
import org.example.kingcrabback.domain.post.like.dto.PostLikeResponse;
import org.example.kingcrabback.domain.post.like.entity.PostLike;
import org.example.kingcrabback.domain.post.like.repository.PostLikeRepository;
import org.example.kingcrabback.domain.user.entity.User;
import org.example.kingcrabback.domain.user.facade.UserFacade;
import org.example.kingcrabback.domain.user.repository.UserRepository;
import org.example.kingcrabback.domain.post.repository.PostRepository;
import org.example.kingcrabback.domain.comment.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentLikeService {

    private final CommentLikeRepository commentLikeRepository;
    private final CommentRepository commentRepository;
    private final UserFacade userFacade;

    @Transactional
    public CommentLikeResponse execute(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        User user = userFacade.getCurrentUser();

        if (isAlreadyLiked(comment, user)) {
            commentLikeRepository.deleteByUserAndComment(user, comment);
            comment.minusLike();
            return new CommentLikeResponse(comment.getCount(), Boolean.FALSE);
        }

        commentLikeRepository.save(
                CommentLike.builder()
                        .user(user)
                        .comment(comment)
                        .build()
        );
        comment.addLike();
        return new CommentLikeResponse(comment.getCount(), Boolean.TRUE);
    }

    private boolean isAlreadyLiked(Comment comment, User user) {
        return commentLikeRepository.existsByUserAndComment(user, comment);
    }
}
