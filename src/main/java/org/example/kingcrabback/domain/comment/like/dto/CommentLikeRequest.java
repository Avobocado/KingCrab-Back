package org.example.kingcrabback.domain.comment.like.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentLikeRequest {
    private final Long commentId;
}
