package com.genesys.task.service;

import com.genesys.task.domain.Response;
import com.genesys.task.domain.ResponseItem;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akapitonov on 05.08.2014.
 */
public class TestTestSorterImpl {

    private SorterService service = new TestSorterImpl();

    @Test
    public void testNormalFlow() throws Exception {
        List<String> payload = new ArrayList<String>();
        payload.add("Sound boy proceed to blast into the galaxy");
        payload.add("Go back rocket man into the sky you'll see");
        payload.add("Hear it all the time, come back rewind");
        payload.add("Sound boy process to blast into the galaxy");
        payload.add("Aliens are watching up in the sky");
        payload.add("No one gonna harm you");
        payload.add("They all want you to play I watch the birds of prey");

        List<ResponseItem> expected = new ArrayList<ResponseItem>();
        expected.add(new ResponseItem("watching", "Aliens are watching up in the sky"));
        expected.add(new ResponseItem("process", "Sound boy process to blast into the galaxy"));
        expected.add(new ResponseItem("proceed", "Sound boy proceed to blast into the galaxy"));
        expected.add(new ResponseItem("rocket", "Go back rocket man into the sky you'll see"));
        expected.add(new ResponseItem("rewind", "Hear it all the time, come back rewind"));

        Assert.assertEquals(expected, service.sort(payload).getResult());
    }

    @Test
    public void testEmptyPayload() throws Exception {
        List<String> payload = new ArrayList<String>();
        Assert.assertEquals(new ArrayList<ResponseItem>(1), service.sort(payload).getResult());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullPayload() throws Exception {
        service.sort(null);
    }
}
