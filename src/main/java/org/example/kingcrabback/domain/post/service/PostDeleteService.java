package org.example.kingcrabback.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.comment.entity.Comment;
import org.example.kingcrabback.domain.comment.exception.CommentNotFoundException;
import org.example.kingcrabback.domain.post.dto.PostRequest;
import org.example.kingcrabback.domain.post.entity.Post;
import org.example.kingcrabback.domain.post.repository.PostRepository;
import org.example.kingcrabback.domain.user.exception.UserMissMatchException;
import org.example.kingcrabback.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostDeleteService {
    private final PostRepository postRepository;
    private final UserFacade userFacade;

    public void deletePost(Long id){
        Post post = postRepository.findById(id).orElseThrow(() -> CommentNotFoundException.EXCEPTION);
        if(userFacade.getCurrentUser().getUserName().equals(post.getUsername())){
            postRepository.delete(post);
        }else{
            throw UserMissMatchException.EXCEPTION;
        }
    }
}
