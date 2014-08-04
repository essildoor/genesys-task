package com.genesys.task.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ResponseItem implements Comparable<ResponseItem> {
    private final String string;
    @JsonIgnore
    private final String longestWordValue;
    private final int longestWord;

    public ResponseItem(String longestWordValue, String string) {
        this.longestWordValue = longestWordValue;
        this.string = string;
        this.longestWord = this.longestWordValue.length();
    }

    public String getString() {
        return string;
    }

    public String getLongestWordValue() {
        return longestWordValue;
    }

    public int getLongestWord() {
        return longestWord;
    }

    @Override
    public int compareTo(ResponseItem o) {
        if (o.equals(this)) return 0;
        if (this.longestWord > o.getLongestWord()) return 1;
        if (this.longestWord < o.getLongestWord()) return -1;
        return this.longestWordValue.compareTo(o.getLongestWordValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseItem that = (ResponseItem) o;

        if (longestWordValue != null ? !longestWordValue.equals(that.longestWordValue) : that.longestWordValue != null) return false;
        if (string != null ? !string.equals(that.string) : that.string != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = string != null ? string.hashCode() : 0;
        result = 31 * result + (longestWordValue != null ? longestWordValue.hashCode() : 0);
        return result;
    }
}
