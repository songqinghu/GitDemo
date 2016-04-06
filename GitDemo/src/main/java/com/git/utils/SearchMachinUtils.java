package com.git.utils;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 对查询主条件进行处理
 * 形式  数字  拼音  汉字  进行模糊匹配查询 
 * @author songqinghu
 *
 */
public class SearchMachinUtils {

    private  static Logger logger = LoggerFactory.getLogger(Pinyin4jUtil.class);
    
    /**
     * 
     * @描述：对查询条件进行处理 获取匹配条件
     * @param condition
     * @return
     * @return String[]
     * @exception
     * @createTime：2016年3月30日
     * @author: songqinghu
     */
    private static StringBuffer getpinyin(String condition){
        
        //设置字符容器类
        StringBuffer pinyinName = new StringBuffer();
        char[] chars = condition.toCharArray();
        //设置拼音转换器
        HanyuPinyinOutputFormat defaultFormat = new  HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        //判断转换拼凑
        for (char c : chars) {
            if(c>128){
                try {
                    String[] strs = PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat);
                    if(strs !=null){
                        for (int i = 0; i < strs.length; i++) {
                            pinyinName.append(strs[i]+"*");// 测试  ceshi*
                            if( i != strs.length -1){
                                pinyinName.append(",");
                            }
                        }
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    logger.error("",e);
                }
            }else if( c >=48 && c<=57  ){//0-9---查询匹配
                pinyinName.append(c+"*"); 
            }else if( c >=65 && c<=90){//A-Z
                pinyinName.append(c+"*");
            }else if( c >=97 && c<=122){//a-z
                pinyinName.append(c+"*");
            }
            pinyinName.append(" "); 
        }
        return pinyinName;
    }
    
    /**
     * 去除多音字重复数据
     * 
     * @param theStr
     * @return
     */ 
    private static List<Map<String, Integer>> discountTheChinese(String theStr) { 
        // 去除重复拼音后的拼音列表 
        List<Map<String, Integer>> mapList = new ArrayList<Map<String, Integer>>(); 
        // 用于处理每个字的多音字，去掉重复 
        Map<String, Integer> onlyOne = null; 
        String[] firsts = theStr.split(" "); 
        // 读出每个汉字的拼音 
        for (String str : firsts) { 
            onlyOne = new Hashtable<String, Integer>(); 
            String[] china = str.split(","); 
            // 多音字处理 
            for (String s : china) { 
                Integer count = onlyOne.get(s); 
                if (count == null) { 
                    onlyOne.put(s, new Integer(1)); 
                } else { 
                    onlyOne.remove(s); 
                    count++; 
                    onlyOne.put(s, count); 
                } 
            } 
            mapList.add(onlyOne); 
        } 
        return mapList; 
    } 
    
    /**
     * 解析并组合拼音，对象合并方案(推荐使用)---返回set<String>
     * 
     * @return
     */ 
    private static  String[]  parseTheChinese( 
            List<Map<String, Integer>> list) { 
        Map<String, Integer> first = MinparseTheChineseByObject(list);
        String [] result = null;
        if (first != null && first.keySet().size()>0) { 
            // 遍历取出组合字符串 
            Set<String> set = first.keySet();
            result = new String[set.size()];
            int i = 0;
            for (String string : set) {
                result[i] = string;
                i++;
            }
        } 
        return result; 
    } 
    
    
    /**
     * 
     * @描述：方法抽取
     * @param list
     * @return
     * @return Map<String,Integer>
     * @exception
     * @createTime：2016年3月22日
     * @author: songqinghu
     */
     private static Map<String,Integer> MinparseTheChineseByObject(
             List<Map<String, Integer>> list){
         Map<String, Integer> first = null; // 用于统计每一次,集合组合数据 
         // 遍历每一组集合 
         for (int i = 0; i < list.size(); i++) { 
             // 每一组集合与上一次组合的Map 
             Map<String, Integer> temp = new Hashtable<String, Integer>(); 
             // 第一次循环，first为空 
             if (first != null) { 
                 // 取出上次组合与此次集合的字符，并保存 
                 for (String s : first.keySet()) { 
                     for (String s1 : list.get(i).keySet()) { 
                         String str = s + s1; 
                         temp.put(str, 1); 
                     } 
                 } 
                 // 清理上一次组合数据 
                 if (temp != null && temp.size() > 0) { 
                     first.clear(); 
                 } 
             } else { 
                 for (String s : list.get(i).keySet()) { 
                     String str = s; 
                     temp.put(str, 1); 
                 } 
             } 
             // 保存组合数据以便下次循环使用 
             if (temp != null && temp.size() > 0) { 
                 first = temp; 
             } 
         } 
         return first;
     }
     
    
    public static String[] getMatching(String condition){
        
        return parseTheChinese(discountTheChinese(getpinyin(condition).toString())); 
    }
    
    
}
