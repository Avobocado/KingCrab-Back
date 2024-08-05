package org.example.kingcrabback.domain.post.like.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostLikeResponse {

    private Integer count;
    private boolean click;
}
