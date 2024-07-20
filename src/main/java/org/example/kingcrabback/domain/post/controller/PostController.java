package org.example.kingcrabback.domain.post.controller;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.post.dto.PostRequest;
import org.example.kingcrabback.domain.post.service.PostCreateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostCreateService postCreateService;

    @PostMapping("/create")
    public void createPost(@RequestBody PostRequest postRequest){
        postCreateService.createPost(postRequest);
    }
}
