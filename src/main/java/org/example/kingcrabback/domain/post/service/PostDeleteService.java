package org.example.kingcrabback.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostDeleteService {
    private final PostRepository postRepository;

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
}
