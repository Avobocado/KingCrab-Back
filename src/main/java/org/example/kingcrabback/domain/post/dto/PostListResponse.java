package org.example.kingcrabback.domain.post.dto;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.post.entity.Post;
import org.example.kingcrabback.domain.post.repository.PostRepository;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PostListResponse {
    private String name;
    private String title;
    private String content;
    private LocalDateTime now;
    private Long PostId;
    private Integer count;
    private Integer commentNum;

    public PostListResponse(Post post){
        this.name = post.getUsername();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.PostId = post.getId();
        this.count = post.getCount();
        this.now = post.getNow();
        this.commentNum = post.getCommentNum();
    }


}
