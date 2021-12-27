package exceptions;

public class DefaultException extends Throwable {

    private String message;

    public DefaultException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DefaultException{" +
                "message='" + message + '\'' +
                '}';
    }
}
