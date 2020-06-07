package com.zucc.edu.javen.tw.util;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.ArrayList;
import java.util.List;

public class AsnjTokenizer implements Tokenizer {
    public List<String> tokenize(String str) {
        List<String> ls = new ArrayList<String>();
        for (Term term : ToAnalysis.parse(str).getTerms()) {
//            System.out.println(term.getRealName());
            ls.add(term.getRealName());
        }


        return ls;
    }

//    public static void main(String[] args) {
//        AsnjTokenizer tokenizer=new AsnjTokenizer();
//        tokenizer.tokenize("这是一句示例句子提供来分词");
//        System.out.println("stop");
//    }
}
