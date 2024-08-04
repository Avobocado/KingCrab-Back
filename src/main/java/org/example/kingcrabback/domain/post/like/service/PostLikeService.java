package org.example.kingcrabback.domain.post.like.service;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.post.like.dto.PostLikeRequest;
import org.example.kingcrabback.domain.post.like.dto.PostLikeResponse;
import org.example.kingcrabback.domain.post.like.entity.PostLike;
import org.example.kingcrabback.domain.post.like.repository.PostLikeRepository;
import org.example.kingcrabback.domain.post.entity.Post;
import org.example.kingcrabback.domain.post.repository.PostRepository;
import org.example.kingcrabback.domain.user.entity.User;
import org.example.kingcrabback.domain.user.facade.UserFacade;
import org.example.kingcrabback.domain.user.repository.UserRepository;
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
    public PostLikeResponse execute(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        User user = userFacade.getCurrentUser();

        if (isAlreadyLiked(post, user)) {
            postLikeRepository.deleteByUserAndPost(user, post);
            post.minusLike();
            return new PostLikeResponse(post.getCount(), Boolean.FALSE);
        }

        postLikeRepository.save(
                PostLike.builder()
                        .user(user)
                        .post(post)
                        .build()
        );
        post.addLike();
        return new PostLikeResponse(post.getCount(), Boolean.TRUE);
    }

    private boolean isAlreadyLiked(Post post, User user) {
        return postLikeRepository.existsByUserAndPost(user, post);
    }}
