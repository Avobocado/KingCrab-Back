package org.example.kingcrabback.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.post.dto.PostListResponse;
import org.example.kingcrabback.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostReadAllService {
    private final PostRepository postRepository;

    public List<PostListResponse> readAllPost(){
        return postRepository.findAll()
                .stream()
                .map(PostListResponse::new)
                .toList();
    }
}
