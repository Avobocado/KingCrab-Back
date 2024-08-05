package org.example.kingcrabback.domain.post.controller;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.post.service.PostCreateService;
import org.example.kingcrabback.domain.post.service.PostDeleteService;
import org.example.kingcrabback.domain.post.service.PostReadAllService;
import org.example.kingcrabback.domain.post.service.PostUpdateService;
import org.example.kingcrabback.domain.post.dto.PostListResponse;
import org.example.kingcrabback.domain.post.dto.PostRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostCreateService postCreateService;
    private final PostDeleteService postDeleteService;
    private final PostUpdateService postUpdateService;
    private final PostReadAllService postAllReadService;

    @PostMapping("/create")
    public void createPost(@RequestBody PostRequest postRequest){
        postCreateService.createPost(postRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePost(@PathVariable Long id){
        postDeleteService.deletePost(id);
    }

    @PatchMapping("/update/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody PostRequest postRequest){
        postUpdateService.updatePost(id, postRequest);
    }

    @GetMapping("/read")
    public List<PostListResponse> readAllPost(){
        return postAllReadService.readAllPost();
    }
}
