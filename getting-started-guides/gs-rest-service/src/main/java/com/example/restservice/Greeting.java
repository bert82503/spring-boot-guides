package com.example.restservice;

/**
 * 问候对象。
 *
 * @author guangyi
 * @since 2022-02-02
 */
@SuppressWarnings("unused")
public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
