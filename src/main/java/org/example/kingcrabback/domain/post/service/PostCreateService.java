package org.example.kingcrabback.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.post.dto.PostRequest;
import org.example.kingcrabback.domain.post.entity.Post;
import org.example.kingcrabback.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostCreateService {
    private final PostRepository postRepository;

    @Transactional
    public Post createPost(PostRequest postRequest){
        return postRepository.save(
            Post.builder()
                    .name(postRequest.getName())
                    .title(postRequest.getTitle())
                    .content(postRequest.getContent())
                    .build()
        );
    }
}
