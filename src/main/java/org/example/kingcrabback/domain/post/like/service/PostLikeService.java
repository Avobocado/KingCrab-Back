package org.example.kingcrabback.domain.post.like.service;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.post.entity.Post;
import org.example.kingcrabback.domain.post.like.repository.PostLikeRepository;
import org.example.kingcrabback.domain.post.repository.PostRepository;
import org.example.kingcrabback.domain.post.like.entity.PostLike;
import org.example.kingcrabback.domain.user.entity.User;
import org.example.kingcrabback.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostLikeService {
    private final PostLikeRepository postLikeRepository;
    private final PostRepository postRepository;
    private final UserFacade userFacade;

    @Transactional
    public String likePost(Long postId) {
        Optional<Post> postOptional = postRepository.findById(postId);
        User user = userFacade.getCurrentUser();
        if (postOptional.isEmpty()) {
            return "유저 또는 포스트를 찾을 수 없습니다.";
        }

        Post post = postOptional.get();

        Optional<PostLike> postLikeOptional = postLikeRepository.findByUserAndPost(user, post);

        if (isAlreadyLiked(post, user)) {
            // 이미 좋아요를 눌렀다면, 좋아요를 취소하고 뉴스의 좋아요 수를 감소시킴
            postLikeRepository.deleteByUserAndPost(user, post);
            post.minusLike();
        }

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

    private boolean isAlreadyLiked(Post post, User user) {
        return postLikeRepository.existsByUserAndPost(user, post);
    }
}
