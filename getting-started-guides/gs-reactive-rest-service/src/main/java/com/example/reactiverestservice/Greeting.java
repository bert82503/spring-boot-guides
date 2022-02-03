package com.example.reactiverestservice;

/**
 * 问候对象。
 *
 * @author guangyi
 * @since 2022-02-03
 */
@SuppressWarnings("unused")
public class Greeting {

    private String message;

    public Greeting() {
    }

    public Greeting(String message) {
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
        return "Greeting{" +
                "message='" + message + '\'' +
                '}';
    }
}
