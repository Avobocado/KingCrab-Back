package org.example.kingcrabback.domain.comment.like.service;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.comment.entity.Comment;
import org.example.kingcrabback.domain.comment.like.entity.CommentLike;
import org.example.kingcrabback.domain.comment.like.repository.CommentLikeRepository;
import org.example.kingcrabback.domain.post.entity.Post;
import org.example.kingcrabback.domain.user.entity.User;
import org.example.kingcrabback.domain.user.facade.UserFacade;
import org.example.kingcrabback.domain.post.repository.PostRepository;
import org.example.kingcrabback.domain.comment.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentLikeService {

    private final CommentLikeRepository commentLikeRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final UserFacade userFacade;

    @Transactional
    public String likeComment(Long postId, Long commentId) {
        User user = userFacade.getCurrentUser();

        Optional<Post> postOptional = postRepository.findById(postId);
        if (postOptional.isEmpty()) {
            return "게시물을 찾을 수 없습니다.";
        }

        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        if (commentOptional.isEmpty()) {
            return "댓글을 찾을 수 없습니다.";
        }

        Post post = postOptional.get();
        Comment comment = commentOptional.get();

        Optional<CommentLike> existingLike = commentLikeRepository.findByUserAndPostAndComment(user, post, comment);
        if (existingLike.isPresent()) {
            commentLikeRepository.delete(existingLike.get());
            return "좋아요가 취소되었습니다.";
        } else {
            CommentLike commentLike = new CommentLike(user, post, comment);
            commentLikeRepository.save(commentLike);
            return "댓글에 좋아요를 눌렀습니다.";
        }
    }
}
