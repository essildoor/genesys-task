package com.genesys.task.domain;

import java.util.List;

public class Request {
    private List<String> strings;

    public Request() {
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }
}
