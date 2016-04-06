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

import org.apache.commons.lang3.StringUtils;

/**
 * 读取配置文件中信息到map中并且能够写入信息到文件中和map中
 * @author songqinghu
 * 可以软加载的方法  定时去加载 一次配置文件 
 */
public class ReadAndWriteTest {

    private final static Map<String,String> dict = new HashMap<String,String>();
    
    public static void main(String[] args) throws IOException {
        String path  = "/pinyindb/gome_hanyu_pinyin_ext.txt";
        //readText(path);
        HashMap<String, String> map = new HashMap<String,String>();
        map.put("E323", "hanzi,hanzi");
        writeText(map);
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
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)));
        Set<Entry<String, String>> entrySet = content.entrySet();
        String line = null;
        for (Entry<String, String> entry : entrySet) {
            line = entry.getKey() +" " +entry.getValue();
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
        if(StringUtils.isNotBlank(path)){
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
