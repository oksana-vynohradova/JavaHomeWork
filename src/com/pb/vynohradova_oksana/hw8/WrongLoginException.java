package com.pb.vynohradova_oksana.hw8;

public class WrongLoginException extends Exception {

    public WrongLoginException() {}

    public WrongLoginException(String message) {
        super(message);
    }
}
