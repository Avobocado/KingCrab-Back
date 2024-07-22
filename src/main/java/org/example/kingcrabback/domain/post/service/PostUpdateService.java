package org.example.kingcrabback.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.post.dto.PostRequest;
import org.example.kingcrabback.domain.post.entity.Post;
import org.example.kingcrabback.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostUpdateService {
    private final PostRepository postRepository;

    public void updatePost(Long id, PostRequest postRequest){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post가 NULL입니다"));

    post.updatePost(
            postRequest.getTitle(),
            postRequest.getContent()
    );

    postRepository.save(post);

    }
}
