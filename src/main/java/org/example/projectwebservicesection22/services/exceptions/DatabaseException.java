package org.example.projectwebservicesection22.services.exceptions;

public class DatabaseException extends RuntimeException {
    public DatabaseException() {
    }
    public DatabaseException(String message) {
        super(message);
    }
}
