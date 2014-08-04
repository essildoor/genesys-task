package com.genesys.task.service;

import com.genesys.task.domain.Response;

import java.util.List;

public interface SorterService {
    /**
     * Sorts strings list
     * @param strings strings list to sort
     * @return Response instance
     */
    public Response sort(List<String> strings);
}
