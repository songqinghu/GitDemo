package com.git.pinyin.smartsplit;

import java.util.List;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.py.Pinyin;
import com.hankcs.hanlp.seg.common.Term;

public class DemoPinyin
{
    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        String text = "zheshiyige";
        List<Pinyin> pinyinList = HanLP.convertToPinyinList(text);
        List<Term> segment = HanLP.segment("美的集团,我买了一个iphone5s,你看看如何");
        for (Term term : segment) {
            System.out.println(term.toString());
        }
        System.out.print("原文,");
        for (char c : text.toCharArray())
        {
            System.out.printf("%c,", c);
       }
       System.out.println();
       System.out.print("拼音（数字音调）,");
       for (Pinyin pinyin : pinyinList)
       {
           System.out.printf("%s,", pinyin);
       }
       System.out.println(System.currentTimeMillis() -start);
       long two = System.currentTimeMillis();
       String text2 = "老王来了!你快独傲起来";
        List<Pinyin> pinyinList2 = HanLP.convertToPinyinList(text2);
        System.out.print("原文,");
        for (char c2 : text2.toCharArray())
        {
            System.out.printf("%c,", c2);
        }
        System.out.println();
        System.out.print("拼音（数字音调）,");
        for (Pinyin pinyin : pinyinList2)
        {
            System.out.printf("%s,", pinyin);
        }
        
//        System.out.println();
//        System.out.print("拼音（数字音调）,");
//        for (Pinyin pinyin : pinyinList)
//        {
//            System.out.printf("%s,", pinyin);
//        }
//        System.out.println();
//        System.out.print("拼音（符号音调）,");
//        for (Pinyin pinyin : pinyinList)
//        {
//            System.out.printf("%s,", pinyin.getPinyinWithToneMark());
//        }
//        System.out.println();
//        System.out.print("拼音（无音调）,");
//        for (Pinyin pinyin : pinyinList)
//        {
//            System.out.printf("%s,", pinyin.getPinyinWithoutTone());
//        }
//        System.out.println();
//        System.out.print("声调,");
//        for (Pinyin pinyin : pinyinList)
//        {
//            System.out.printf("%s,", pinyin.getTone());
//        }
//        System.out.println();
//        System.out.print("声母,");
//        for (Pinyin pinyin : pinyinList)
//        {
//            System.out.printf("%s,", pinyin.getShengmu());
//        }
//        System.out.println();
//        System.out.print("韵母,");
//        for (Pinyin pinyin : pinyinList)
//        {
//            System.out.printf("%s,", pinyin.getYunmu());
//        }
//        System.out.println();
//        System.out.print("输入法头,");
//        for (Pinyin pinyin : pinyinList)
//        {
//            System.out.printf("%s,", pinyin.getHead());
//        }
        System.out.println(System.currentTimeMillis() -two);
    }
}
