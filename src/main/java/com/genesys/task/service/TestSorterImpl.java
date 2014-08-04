package com.genesys.task.service;

import com.genesys.task.domain.Response;
import com.genesys.task.domain.ResponseItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class TestSorterImpl implements SorterService {

    private static final Logger LOGGER = LogManager.getLogger(TestSorterImpl.class);

    private static final int THRESHOLD = 5;

    @Override
    public Response sort(List<String> strings) {
        if (strings == null) {
            LOGGER.error("Payload cannot be null!");
            throw new IllegalArgumentException("Payload cannot be null!");
        }

        if (strings.size() == 0) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Empty payload!");
            }
            return new Response(new ArrayList<ResponseItem>(1));
        }

        List<ResponseItem> result = new ArrayList<ResponseItem>(strings.size());

        for (String s : strings) {
            result.add(new ResponseItem(findLongestWord(s), s));
        }

        Collections.sort(result);
        Collections.reverse(result);
        result = result.subList(0, THRESHOLD);

        return new Response(result);
    }

    private String findLongestWord(String string) {
        if (string == null || string.length() == 0) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("null or empty string: " + string + " return 0!");
            }
            return "";
        }
        StringTokenizer st = new StringTokenizer(string, " ,.!?:;'");
        String word = null;
        String longestWord = "";
        while (st.hasMoreElements()) {
            word = st.nextToken();
            if (word.length() > longestWord.length()) {
                longestWord = word;
            } else if (word.length() == longestWord.length()) {
                longestWord = word.compareTo(longestWord) > 0 ? word : longestWord;
            }
        }
        return longestWord;
    }
}
