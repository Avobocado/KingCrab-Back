package org.example.kingcrabback.domain.comment.controller;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.comment.dto.request.CommentRequest;
import org.example.kingcrabback.domain.comment.dto.response.CommentResponse;
import org.example.kingcrabback.domain.comment.entity.Comment;
import org.example.kingcrabback.domain.comment.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
@RequiredArgsConstructor
public class CommentController {

    private final CreateComment createComment;
    private final DeleteComment deleteComment;
    private final ReadComment readComment;
    private final UpdateComment updateComment;


    @PostMapping("/create")
    public void createComment(@RequestBody CommentRequest commentRequest) {
        createComment.createComment(commentRequest);
    }

    @GetMapping("/read/{postId}")
    public List<CommentResponse> readComment(@PathVariable Long postId) {
        return readComment.readALlComment(postId);
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
