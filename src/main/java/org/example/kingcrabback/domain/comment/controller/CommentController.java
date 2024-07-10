package org.example.kingcrabback.domain.comment.controller;

import org.example.kingcrabback.domain.comment.dto.CommentRequest;
import org.example.kingcrabback.domain.comment.entity.Comment;
import org.example.kingcrabback.domain.comment.repository.CommentRepository;
import org.example.kingcrabback.domain.comment.service.CommentService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

@RestController("/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/save")
    public void saveComment(CommentRequest commentRequest) {
        //commentRequest id 가
        commentService.saveComment(commentRequest);
    }

    @GetMapping("/get/{commentId}")
    public Comment getComment(@PathVariable Long commentId) {
        return commentService.getComment(commentId);
    }

    @DeleteMapping("/delete/{commendId}")
    public void deleteComment(@PathVariable Long commendId) {
        commentService.deleteComment(commendId);
    }

    @PatchMapping("/update")
    public void updateComment(@RequestBody CommentRequest commentRequest){
        commentService.updateComment(commentRequest);
    }
}
