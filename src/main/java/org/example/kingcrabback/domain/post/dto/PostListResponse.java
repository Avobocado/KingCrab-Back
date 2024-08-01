package org.example.kingcrabback.domain.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.example.kingcrabback.domain.post.entity.Post;

@Getter
@Builder
@AllArgsConstructor
public class PostListResponse {
    private String name;
    private String title;
    private String content;

    public PostListResponse(Post post){
        this.name = post.getName();
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
