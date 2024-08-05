package org.example.kingcrabback.domain.post.like.controller;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.post.like.dto.PostLikeResponse;
import org.example.kingcrabback.domain.post.like.service.PostLikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostLikeController {
    private final PostLikeService postLikeService;

    @PostMapping("/like/{id}")
    public PostLikeResponse likePost(@PathVariable Long id) {
         return postLikeService.execute(id);
    }
}
