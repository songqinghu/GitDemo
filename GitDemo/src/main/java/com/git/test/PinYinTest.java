package com.git.test;

import java.util.List;

import com.git.utils.SearchMachinUtils;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLSentence;
import com.hankcs.hanlp.dependency.CRFDependencyParser;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;

public class PinYinTest {

    public static void main(String[] args) {
        String[] matching = SearchMachinUtils.getMatching("盛世1234ksdjakl光明");
        for (String string : matching) {
            System.out.println(string);
        }
        String t = HanLP.convertToPinyinFirstCharString("长沙市长", "", false);
        String x2 = HanLP.convertToPinyinString("长沙市长", "", false);
        System.out.println(t);
        System.out.println(x2);
        
        String text = "宝宝洗浴巾";
        List<String> phraseList = HanLP.extractPhrase(text, 1);
        System.out.println(phraseList);
        
        List<Term> termList = NLPTokenizer.segment("中国科学院计算技术研究所的宗成庆教授正在教授自然语言处理课程");
        System.out.println(termList);

    }
}
