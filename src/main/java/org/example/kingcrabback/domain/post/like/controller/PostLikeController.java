package org.example.kingcrabback.domain.post.like.controller;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.post.like.dto.PostLikeRequest;
import org.example.kingcrabback.domain.post.like.service.PostLikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
@RequiredArgsConstructor
public class PostLikeController {
    private final PostLikeService postLikeService;

    @PostMapping
    public ResponseEntity<String> likePost(@RequestBody PostLikeRequest postLikeRequest) {
        String result = postLikeService.likePost(postLikeRequest);
        return ResponseEntity.ok(result);
    }
}
