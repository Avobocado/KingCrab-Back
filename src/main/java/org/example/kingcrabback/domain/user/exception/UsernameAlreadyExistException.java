package org.example.kingcrabback.domain.user.exception;

import org.example.kingcrabback.domain.utill.error.ErrorCode;
import org.example.kingcrabback.domain.utill.error.exception.CustomException;

import javax.swing.undo.CannotUndoException;

public class UsernameAlreadyExistException extends CustomException {
    public static final CustomException EXCEPTION = new UsernameAlreadyExistException();

    public UsernameAlreadyExistException() {
        super(ErrorCode.NICKNAME_ALREADY_EXISTS);
    }
}
