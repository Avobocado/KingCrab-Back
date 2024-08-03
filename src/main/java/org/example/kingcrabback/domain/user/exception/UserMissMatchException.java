package org.example.kingcrabback.domain.user.exception;

import org.example.kingcrabback.domain.utill.error.ErrorCode;
import org.example.kingcrabback.domain.utill.error.exception.CustomException;



public class UserMissMatchException extends CustomException {
    public static final CustomException EXCEPTION = new UserMissMatchException();

    public UserMissMatchException() {
        super(ErrorCode.USER_MISS_MATCH);
    }
}
