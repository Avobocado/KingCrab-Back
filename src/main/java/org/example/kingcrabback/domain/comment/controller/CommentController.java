package org.example.kingcrabback.domain.comment.controller;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.comment.dto.CommentRequest;
import org.example.kingcrabback.domain.comment.entity.Comment;
import org.example.kingcrabback.domain.comment.service.*;
import org.springframework.web.bind.annotation.*;

@RestController("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CreateComment createComment;
    private final DeleteComment deleteComment;
    private final ReadComment readComment;
    private final UpdateComment updateComment;


    @PostMapping("/create")
    public void createComment(CommentRequest commentRequest) {
        createComment.createComment(commentRequest);
    }

    @GetMapping("/read/{commentId}")
    public Comment readComment(@PathVariable Long commentId) {
        return readComment.readComment(commentId);
    }

    @DeleteMapping("/delete/{commendId}")
    public void deleteComment(@PathVariable Long commendId) {
        deleteComment.deleteComment(commendId);
    }

    @PatchMapping("/update")
    public void updateComment(@RequestBody CommentRequest commentRequest){
        updateComment.updateComment(commentRequest);
    }
}
