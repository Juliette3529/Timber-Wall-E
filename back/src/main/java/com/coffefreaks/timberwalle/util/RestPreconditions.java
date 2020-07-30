package com.coffefreaks.timberwalle.util;

import com.coffefreaks.timberwalle.exception.TimberResourceNotFoundException;

public class RestPreconditions {

    private RestPreconditions() {
        throw new AssertionError();
    }

    // API
    /**
     * Check if some value was found, otherwise throw exception.
     *
     * @param expression
     *            has value true if found, otherwise false
     * @throws TimberResourceNotFoundException
     *             if expression is false, means value not found.
     */
    public static void checkFound(final boolean expression) {
        if (!expression) {
            throw new TimberResourceNotFoundException();
        }
    }

    /**
     * Check if some value was found, otherwise throw exception.
     *
     * @param resource
     *            has value true if found, otherwise false
     * @throws TimberResourceNotFoundException
     *             if expression is false, means value not found.
     */
    public static <T> T checkFound(final T resource) {
        if (resource == null) {
            throw new TimberResourceNotFoundException();
        }

        return resource;
    }
}
