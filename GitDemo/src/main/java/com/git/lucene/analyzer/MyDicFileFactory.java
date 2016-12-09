package com.git.lucene.analyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

/**
 * @Description: 从文件中生成字典
 * @author: songqinghu
 * @date: 2016年12月8日 下午4:11:58
 * Version:1.0
 */
public class MyDicFileFactory implements MyDicFactory{

    public static final String dicDic = "E:\\java\\word\\dic";//默认词典
    public static final String txtDic = "baseWords.txt";
    public static final String binDic = "baseWords.bin";
    
    
    
    @Override
    public MyTernarySearchTrie create() {
        
        MyTernarySearchTrie dic = new MyTernarySearchTrie();//字典树
        
        File binFile = new File(dicDic, binDic);
        
        if(!binFile.exists()){
            
            File txtFile = new File(dicDic, txtDic);
            
            loadDictionay(dic,txtFile);
            
            dic.compileDic(binFile);//创建二进制文件
            
            
            
            
            
        }else{
            //加载二进制数据
            dic.loadBinaryDataFile(binFile);
        }
        
        return dic;
    }



    private void loadDictionay(MyTernarySearchTrie dic, File txtFile) {
        
        try {
            FileInputStream input = new FileInputStream(txtFile);
            
            BufferedReader read = new BufferedReader(new InputStreamReader(input, "UTF-8"));

            String line;
            
            while((line =read.readLine())!=null){
                    
                    if("".equals(line)){
                        continue;
                    }
                    
                    StringTokenizer st = new StringTokenizer(line, "\t");
                    String key = st.nextToken();
                    dic.addWord(key);
            }
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}
