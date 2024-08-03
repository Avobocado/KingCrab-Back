package org.example.kingcrabback.domain.utill.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.kingcrabback.domain.utill.error.ErrorCode;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{

    private ErrorCode errorCode;
}
