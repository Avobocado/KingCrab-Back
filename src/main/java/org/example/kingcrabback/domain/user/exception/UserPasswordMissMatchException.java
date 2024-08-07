package org.example.kingcrabback.domain.user.exception;

import org.example.kingcrabback.domain.utill.error.ErrorCode;
import org.example.kingcrabback.domain.utill.error.exception.CustomException;

public class UserPasswordMissMatchException extends CustomException {
    public static final CustomException EXCEPTION = new UserPasswordMissMatchException();

    public UserPasswordMissMatchException() {
        super(ErrorCode.PASSWORD_MISS_MATCH);
    }
}
