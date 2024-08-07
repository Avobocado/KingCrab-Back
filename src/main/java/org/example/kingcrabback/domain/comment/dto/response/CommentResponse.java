package org.example.kingcrabback.domain.comment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.kingcrabback.domain.comment.entity.Comment;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {
    private String username;
    private LocalDateTime now;
    private String comment;
    private Long commentId;
    private Integer count;
    private Integer countNum;

    public CommentResponse(Comment comment) {
        this.username = comment.getUsername();
        this.now = comment.getNow();
        this.comment = comment.getUsername();
        this.commentId = comment.getId();
        this.count = comment.getCount();
    }
}
