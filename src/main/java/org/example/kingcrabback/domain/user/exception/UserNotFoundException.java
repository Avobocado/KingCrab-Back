package org.example.kingcrabback.domain.user.exception;

import org.example.kingcrabback.domain.utill.error.ErrorCode;
import org.example.kingcrabback.domain.utill.error.exception.CustomException;

public class UserNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new UserNotFoundException();

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
