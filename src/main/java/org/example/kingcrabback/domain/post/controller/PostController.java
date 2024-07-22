package org.example.kingcrabback.domain.post.controller;

import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
import org.example.kingcrabback.domain.post.dto.PostListResponse;
import org.example.kingcrabback.domain.post.dto.PostRequest;
import org.example.kingcrabback.domain.post.service.PostReadAllService;
=======
import org.example.kingcrabback.domain.post.dto.PostRequest;
>>>>>>> origin/post
import org.example.kingcrabback.domain.post.service.PostCreateService;
import org.example.kingcrabback.domain.post.service.PostDeleteService;
import org.example.kingcrabback.domain.post.service.PostUpdateService;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> origin/post
@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostCreateService postCreateService;
    private final PostDeleteService postDeleteService;
    private final PostUpdateService postUpdateService;
<<<<<<< HEAD
    private final PostReadAllService postAllReadService;
=======
>>>>>>> origin/post

    @PostMapping("/create")
    public void createPost(@RequestBody PostRequest postRequest){
        postCreateService.createPost(postRequest);
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable Long id, @RequestBody PostRequest postRequest){
        postDeleteService.deletePost(id, postRequest);
    }

    @PatchMapping("{id}")
    public void updatePost(@PathVariable Long id, @RequestBody PostRequest postRequest){
        postUpdateService.updatePost(id, postRequest);
    }
<<<<<<< HEAD

    @GetMapping()
    public List<PostListResponse> readAllPost(){
        return postAllReadService.readAllPost();
    }
=======
>>>>>>> origin/post
}
