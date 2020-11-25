package dev.top.exception;

public class CheckCollegue extends TopCollegueException {

    public CheckCollegue() {
        super();
    }

    public CheckCollegue(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckCollegue(String message) {
        super(message);
    }

    public CheckCollegue(Throwable cause) {
        super(cause);
    }

}