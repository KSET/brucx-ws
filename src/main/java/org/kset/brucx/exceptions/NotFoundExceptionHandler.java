package org.kset.brucx.exceptions;

import org.kset.brucx.exceptions.handlers.ResourceNotFoundException;
import org.kset.brucx.models.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * Created by marin on 19.12.2016..
 */
@ControllerAdvice
public class NotFoundExceptionHandler {

    @Autowired
    private Environment env;

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> handle(RuntimeException e) {
        RestException r = new RestException();
        r.setException(e.getClass().getSimpleName());
        r.setMessage(e.getMessage());
        if (env.acceptsProfiles("dev")) {
            r.setStacktrace(Arrays.toString(e.getStackTrace()));
        }
        r.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(r, HttpStatus.NOT_FOUND);
    }

}
