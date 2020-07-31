package com.coffefreaks.timberwalle.exception;

public class TimberResourceNotFoundException extends RuntimeException {

    public TimberResourceNotFoundException() {
        super();
    }

    public TimberResourceNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public TimberResourceNotFoundException(final String message) {
        super(message);
    }

    public TimberResourceNotFoundException(final Throwable cause) {
        super(cause);
    }
}
