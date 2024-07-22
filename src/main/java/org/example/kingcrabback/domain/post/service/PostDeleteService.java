package org.example.kingcrabback.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.post.dto.PostRequest;
import org.example.kingcrabback.domain.post.entity.Post;
import org.example.kingcrabback.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostDeleteService {
    private final PostRepository postRepository;

    public void deletePost(Long id, PostRequest postRequest){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(""));
        if(!post.getName().equals(postRequest.getName())){
            throw new RuntimeException("");
        }
        postRepository.delete(post);
    }
}
