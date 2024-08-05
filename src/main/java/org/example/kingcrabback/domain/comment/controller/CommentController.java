package org.example.kingcrabback.domain.comment.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.comment.dto.request.CommentRequest;
import org.example.kingcrabback.domain.comment.dto.response.CommentResponse;
import org.example.kingcrabback.domain.comment.entity.Comment;
import org.example.kingcrabback.domain.comment.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"Comment관련 api"})
@RestController
@RequestMapping("comment")
@RequiredArgsConstructor
public class CommentController {

    private final CreateComment createComment;
    private final DeleteComment deleteComment;
    private final ReadComment readComment;
    private final UpdateComment updateComment;

    @ApiOperation(value = "comment를 생성하는 메서드")
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
