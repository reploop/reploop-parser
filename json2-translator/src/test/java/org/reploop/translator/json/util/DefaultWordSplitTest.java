package org.reploop.translator.json.util;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DefaultWordSplitTest {

    DefaultWordSplit dws = new DefaultWordSplit();

    @Before
    public void setUp() throws Exception {
        dws.load("/ws.txt");
    }

    @Test
    public void build() throws Exception {
        dws.print();
    }

    @Test
    public void parseWord() throws Exception {
        String org = "youref";
        List<String> words = dws.parseWords(org);
        System.out.println(words);

        org = "xyouref";
        words = dws.parseWords(org);
        System.out.println(words);

        org = "test";
        words = dws.parseWords(org);
        System.out.println(words);
    }

    @Test
    public void name() {
        String org = "test";
        List<String> words = dws.parseWords(org);
        System.out.println(words);
    }
}