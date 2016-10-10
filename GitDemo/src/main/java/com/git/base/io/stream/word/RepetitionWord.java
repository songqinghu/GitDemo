package com.git.base.io.stream.word;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 去除重复词语
 * @Description: TODO
 * @author: songqinghu
 * @date: 2016年9月27日 上午10:58:40
 * Version:1.0
 */
public class RepetitionWord {

    private static String defaultPath = "D:\\words";
    
    private static File traningTextDir = new File(defaultPath);
    
    private static String fileName = "lex-ext-name.lex";
    
    public static void main(String[] args) {
        
        getFilesPath(fileName);
   
    }
    
    
    /**
    * 根据训练文本类别返回这个类别下的所有训练文本路径（full path）
    * @param classification 给定的分类
    * @return 给定分类下所有文件的路径（full path）
    */
    public static  File getFilesPath(String classification) 
    {
        File classDir = new File(traningTextDir.getPath() +File.separator +classification);

        return classDir;
    }

    /**
    * 返回给定路径的文本文件内容
    * @param filePath 给定的文本文件路径
    * @return 文本内容
    * @throws java.io.FileNotFoundException
    * @throws java.io.IOException
    */
    public static String getText(String filePath) throws FileNotFoundException,IOException 
    {
    
        InputStreamReader isReader =new InputStreamReader(new FileInputStream(filePath),"GBK");
        BufferedReader reader = new BufferedReader(isReader);
        String aline;
        StringBuilder sb = new StringBuilder();
    
        while ((aline = reader.readLine()) != null)
        {
            sb.append(aline + " ");
        }
        isReader.close();
        reader.close();
        return sb.toString();
    }
}
