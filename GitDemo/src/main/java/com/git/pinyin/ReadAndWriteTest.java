package com.git.pinyin;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



/**
 * 读取配置文件中信息到map中并且能够写入信息到文件中和map中
 * @author songqinghu
 * 可以软加载的方法  定时去加载 一次配置文件 
 */
public class ReadAndWriteTest {

    private final static Map<String,String> dict = new HashMap<String,String>();
    
    public static void main(String[] args) throws IOException {
        String path  = "/pinyindb/gome_hanyu_pinyin_ext.txt";
       // readText(path);
       // HashMap<String, String> map = new HashMap<String,String>();
       // map.put("我是好人", "wo");
       // map.put("我", "wo");
       // map.put("是", "shi");
        //map.put("好", "hao,ren");
        //writeText(map);
        unicodeTohanzi("3007");  // 龦 9FA6 cháng
    }
    private static void unicodeTohanzi(String unicode){
        
        int code = Integer.parseInt(unicode, 16);
        System.out.println((char)code);
        
    }
    /**
     * 
     * @描述：将汉字和拼音写入文件中  汉字  拼音集合 xxx,xxx,xxx
     * @param content
     * @return void
     * @exception
     * @createTime：2016年4月6日
     * @author: songqinghu
     * @throws IOException 
     */
    public static void writeText(Map<String,String> content) throws IOException{
        String path = ReadAndWriteTest.class.getResource("/pinyindb/gome_hanyu_pinyin_ext.txt").getPath();
        System.out.println(path);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, true)));
        Set<Entry<String, String>> entrySet = content.entrySet();
        String line = null;
        //writer.newLine();
        for (Entry<String, String> entry : entrySet) {
            String key = entry.getKey();
            char[] charArray = key.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if(i!=0){
                    break;
                }
                key = Integer.toHexString(charArray[i]);
            }
            line = key +" (" +entry.getValue()+")";
            writer.write(line);
            writer.newLine();
        }
        writer.flush();
        writer.close();
        System.out.println("====");
    }
    
    
    
    /**
     * 
     * @描述：读取文件中信息到map中
     * @param path  文件路径  格式 "/pinyindb/gome_hanyu_pinyin_ext.txt"
     * @return void
     * @exception
     * @createTime：2016年4月6日
     * @author: songqinghu
     * @throws IOException 
     */
    private static synchronized void readText(String path){
        if(path!=null && path.trim().length()>0){
            BufferedReader reader = new BufferedReader(new InputStreamReader(ReadAndWriteTest.class.getResourceAsStream(path)));
            if(reader != null){
                String line=null;
                try {
                    while((line = reader.readLine())!=null){//读取一行到String中
                        String[] values = line.split(" ");
                        if(values.length != 2){
                            continue;
                        }
                        String unicode = values[0];
                        int code = Integer.parseInt(unicode, 16);
                        char ch = (char) code;
                        String pinyin  = values[1];
                        System.out.println("编码后的字符: " + unicode + "  对应的拼音:"+ pinyin);
                        System.out.println(ch);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(reader !=null){
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        
    }
    
}
