package com.zucc.edu.javen.tw.util;

import java.util.ArrayList;
import java.util.List;

public class NgramsTokenizer implements Tokenizer {

    public List<String> tokenize(String str) {
        List<String> ls = new ArrayList<String>();
        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length()) {
                String token = str.substring(i, i + 2);
                ls.add(token);
            }

        }
        for (int i = 0; i < str.length(); i++) {
            if (i + 2 < str.length()) {
                String token = str.substring(i, i + 3);
                ls.add(token);
            }

        }

        return ls;
    }
}
