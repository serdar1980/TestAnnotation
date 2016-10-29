package ru.serdar1980.handler;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.serdar1980.entity.ExceptionJSONInfo;

import java.text.MessageFormat;

/**
 * Created by Serdar on 29.10.2016.
 */
@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public
    @ResponseBody
    ExceptionJSONInfo handleException(Exception exception) {
        String fieldError = ((MethodArgumentNotValidException) exception).getBindingResult().getFieldError().toString();
        //String objectName= ((MethodArgumentNotValidException) exception).getBindingResult().getObjectName();

        ExceptionJSONInfo exceptionJSONInfo = new ExceptionJSONInfo();
        exceptionJSONInfo.setMessage(MessageFormat.format("Validation exception {0}", fieldError).toString());
        exceptionJSONInfo.setStacktrace(ExceptionUtils.getStackTrace(exception));
        exceptionJSONInfo.setType("");
        return exceptionJSONInfo;
    }
}

