package com.genesys.task.controller;

import com.genesys.task.domain.Request;
import com.genesys.task.domain.Response;
import com.genesys.task.domain.ResponseItem;
import com.genesys.task.service.SorterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Component
@Controller
@RequestMapping("/test")
public class TestController {
    private static final Logger LOGGER = LogManager.getLogger(TestController.class);

    private SorterService sorterService;

    public TestController(SorterService sorterService) {
        this.sorterService = sorterService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody
    Response getResult(@RequestBody Request request) {
        if (request == null) {
            LOGGER.error("request is null!");
            throw new IllegalArgumentException("request is null!");
        }
        return sorterService.sort(request.getStrings());
    }
}
