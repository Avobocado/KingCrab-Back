package org.example.kingcrabback.domain.post.like.controller;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.post.like.service.PostLikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostLikeController {
    private final PostLikeService postLikeService;

    @PostMapping("/like/{post-id}")
    public ResponseEntity<String> likePost(@PathVariable(value = "post-id")Long id) {
        String result = postLikeService.likePost(id);
        return ResponseEntity.ok(result);
    }
}
