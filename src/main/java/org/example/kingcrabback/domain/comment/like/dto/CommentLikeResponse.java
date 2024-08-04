package org.example.kingcrabback.domain.comment.like.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentLikeResponse {
    private Integer count;
    private boolean click;
}
