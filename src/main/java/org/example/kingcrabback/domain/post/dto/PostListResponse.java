package org.example.kingcrabback.domain.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.example.kingcrabback.domain.post.entity.Post;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class PostListResponse {
    private String name;
    private String title;
    private String content;
    private LocalDateTime now;
    private Long PostId;
    private Integer count;

    public PostListResponse(Post post){
        this.name = SecurityContextHolder.getContext().getAuthentication().getName();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.PostId = post.getId();
        this.count = post.getCount();
        this.now = post.getNow();
    }
}
