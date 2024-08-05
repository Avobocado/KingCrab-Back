package org.example.kingcrabback.domain.comment.like;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.comment.like.service.CommentLikeService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/comment")
@RequiredArgsConstructor
public class CommentLikeController {
    private final CommentLikeService commentLikeService;

    @PostMapping("/like/{post-id}/{comment-id}")
    public String like(@PathVariable(value = "post-id") Long postId, @PathVariable(value = "comment-id")Long commentId) {
      //  return commentLikeService.likeComment(postId, commentId);
        return "a";
    }
}
