package com.genesys.task.domain;

import java.util.List;

public class Response {
    private final List<ResponseItem> result;

    public Response(List<ResponseItem> result) {
        this.result = result;
    }

    public List<ResponseItem> getResult() {
        return result;
    }
}
