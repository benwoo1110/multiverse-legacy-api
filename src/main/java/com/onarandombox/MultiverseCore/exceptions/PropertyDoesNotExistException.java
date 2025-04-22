package com.onarandombox.MultiverseCore.exceptions;

/**
 * Thrown when a world-property doesn't exist.
 */
public class PropertyDoesNotExistException extends Exception {
    public PropertyDoesNotExistException(String name) {
        super(name);
    }

    public PropertyDoesNotExistException(String name, Throwable cause) {
        super(name, cause);
    }
}
