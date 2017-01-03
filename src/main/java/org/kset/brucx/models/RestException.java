package org.kset.brucx.models;

import java.time.LocalDateTime;

/**
 * Class for containing exception details
 *
 */
public class RestException {

    private String exception;

    private String message;

    private LocalDateTime timestamp;

    private String stacktrace;

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getStacktrace() {
        return stacktrace;
    }

    public void setStacktrace(String stacktrace) {
        this.stacktrace = stacktrace;
    }

    @Override
    public String toString() {
        return "RestException{" +
                "exception='" + exception + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", stacktrace='" + stacktrace + '\'' +
                '}';
    }
}
