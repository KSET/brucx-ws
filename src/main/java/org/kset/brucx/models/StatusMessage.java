package org.kset.brucx.models;

/**
 * Created by marin on 19.12.2016..
 */
public class StatusMessage {

    private Integer status;

    private String message;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatusMessage that = (StatusMessage) o;

        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        return message != null ? message.equals(that.message) : that.message == null;

    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StatusMessage{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
