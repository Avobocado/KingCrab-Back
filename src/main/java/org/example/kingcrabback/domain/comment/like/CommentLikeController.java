package org.example.kingcrabback.domain.comment.like;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.comment.like.dto.CommentLikeResponse;
import org.example.kingcrabback.domain.comment.like.service.CommentLikeService;
import org.example.kingcrabback.domain.post.like.dto.PostLikeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentLikeController {
    private final CommentLikeService commentLikeService;

    @PostMapping("/like/{id}")
    public CommentLikeResponse likeComment(@PathVariable Long id) {
        return commentLikeService.execute(id);
    }
}
