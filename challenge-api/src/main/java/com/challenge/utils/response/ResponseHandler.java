package com.challenge.utils.response;

public class ResponseHandler {
    private final boolean isValid;
    private final String message;

    private ResponseHandler(final boolean isValid, final String message) {
        this.isValid = isValid;
        this.message = message;
    }

    public static ResponseHandler of (final boolean isValid, final String message) {
        return new ResponseHandler(isValid, message);
    }

    public static ResponseHandler of (final boolean isValid) {
        return new ResponseHandler(isValid, "Senha válida");
    }

    public boolean isValid() {
        return isValid;
    }

    public String getMessage() {
        return message;
    }
}
