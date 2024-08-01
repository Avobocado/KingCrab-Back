package org.example.kingcrabback.domain.post.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PostResponse {
    private Long id;

    private static List<PostListResponse> responseList;
}
