package com.bergerlevrault.Remoteassist.Exception;


public class UserNotActivatedException extends RuntimeException {
    public UserNotActivatedException(String message) {
        super(message);
    }
}