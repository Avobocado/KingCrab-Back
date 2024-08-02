package org.example.kingcrabback.domain.comment.like.service;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.comment.entity.Comment;
import org.example.kingcrabback.domain.comment.like.dto.CommentLikeRequest;
import org.example.kingcrabback.domain.comment.like.entity.CommentLike;
import org.example.kingcrabback.domain.comment.like.repository.CommentLikeRepository;
import org.example.kingcrabback.domain.post.entity.Post;
import org.example.kingcrabback.domain.user.entity.User;
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
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public String likeComment(CommentLikeRequest request) {
        Optional<User> userOptional = userRepository.findByUserName(request.getUsername());
        if (userOptional.isEmpty()) {
            return "사용자를 찾을 수 없습니다.";
        }

        Optional<Post> postOptional = postRepository.findById(request.getPostId());
        if (postOptional.isEmpty()) {
            return "게시물을 찾을 수 없습니다.";
        }

        Optional<Comment> commentOptional = commentRepository.findById(request.getCommentId());
        if (commentOptional.isEmpty()) {
            return "댓글을 찾을 수 없습니다.";
        }

        User user = userOptional.get();
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
