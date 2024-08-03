package org.example.kingcrabback.domain.comment.exception;

import org.example.kingcrabback.domain.utill.error.ErrorCode;
import org.example.kingcrabback.domain.utill.error.exception.CustomException;

public class CommentNotFoundException extends CustomException {
    public static final CustomException EXCEPTION = new CommentNotFoundException();

    public CommentNotFoundException() {
        super(ErrorCode.COMMENT_NOT_FOUND);
    }
}
