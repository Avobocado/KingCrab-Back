package org.example.kingcrabback.domain.post.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.post.dto.PostRequest;
import org.example.kingcrabback.domain.post.entity.Post;
import org.example.kingcrabback.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostCreateService {
    private final PostRepository postRepository;

    @Transactional
    public Post createPost(PostRequest postRequest){
        return postRepository.save(
            Post.builder()
                    .title(postRequest.getTitle())
                    .content(postRequest.getContent())
                    .name(postRequest.getName())
                    .build()
        );
    }
}
