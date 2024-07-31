package org.example.kingcrabback.domain.post.like.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.post.like.dto.PostLikeRequest;
import org.example.kingcrabback.domain.post.like.entity.PostLike;
import org.example.kingcrabback.domain.post.like.repository.PostLikeRepository;
import org.example.kingcrabback.domain.post.entity.Post;
import org.example.kingcrabback.domain.post.repository.PostRepository;
import org.example.kingcrabback.domain.user.entity.User;
import org.example.kingcrabback.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostLikeService {
    private final PostLikeRepository postLikeRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional
    public String likePost(PostLikeRequest postLikeRequest) {
        Optional<User> userOptional = userRepository.findByUserName(postLikeRequest.getUsername());
        Optional<Post> postOptional = postRepository.findById(postLikeRequest.getPostId());

        if (userOptional.isEmpty() || postOptional.isEmpty()) {
            return "유저 또는 포스트를 찾을 수 없습니다.";
        }

        User user = userOptional.get();
        Post post = postOptional.get();

        Optional<PostLike> postLikeOptional = postLikeRepository.findByUserAndPost(user, post);

        if (postLikeOptional.isEmpty()) {
            PostLike postLike = new PostLike();
            postLike.setUser(user);
            postLike.setPost(post);
            postLikeRepository.save(postLike);
            return "좋아요 추가 성공^^";
        } else {
            // PostLike already exists
            return "이미 좋아요를 누르셨습니다.";
        }
    }
}
