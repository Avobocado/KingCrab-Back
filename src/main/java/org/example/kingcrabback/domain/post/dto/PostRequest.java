package org.example.kingcrabback.domain.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.kingcrabback.domain.post.entity.Post;

@NoArgsConstructor
@Getter
@Setter
public class PostRequest {
    private String title;
    private String content;
    private String name;

    @Builder
    public PostRequest(String title, String content, String name) {
        this.title = title;
        this.content = content;
        this.name = name;
    }

    public Post toEntity() {
        return Post.builder()
                .content(content)
                .title(title)
                .name(name)
                .build();
    }

}
