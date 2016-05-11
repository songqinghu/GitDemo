package com.git.pinyin;


import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 拼音测试类 --测试汉字转为拼音的原理--源代码解析 --抽取封装
 * @author songqinghu
 *
 */
public class PinYinTest {

    public static void main(String[] args) throws Exception {
        //wordToPY("瘦");
        //wordToPY("痩");
        wordToPY("骉");
        //wordToPY("靁");
       // wordToPY("飝");
    }
    /**
     * 
     * @描述：汉字变为拼音的测试类
     * @param word
     * @return void
     * @exception
     * @createTime：2016年4月5日
     * @author: songqinghu
     * @throws BadHanyuPinyinOutputFormatCombination 
     */
    public static void  wordToPY(String word) throws BadHanyuPinyinOutputFormatCombination{
        char[] chars = word.toCharArray();
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (char c : chars) {
            if(c>128){
                    String[] strs = PinyinHelper.toHanyuPinyinStringArray(c, format);
                    for (String string : strs) {
                        System.out.println(string);
                    }
            }
        }
    }
}
