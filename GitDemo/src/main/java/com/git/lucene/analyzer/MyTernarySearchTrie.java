package com.git.lucene.analyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 
 * @Description: 我的字典搜索树
 * @author: songqinghu
 * @date: 2016年12月7日 下午6:35:40
 * Version:1.0
 */
public class MyTernarySearchTrie {

    
    public final class TSTNode{
        public char[] data =null;
        
        protected TSTNode paNode;
        protected TSTNode loNode;
        protected TSTNode eqNode;
        protected TSTNode hiNode;
        
        public char spliter;//词语
        
        public TSTNode(char key,TSTNode parent){
            
            this.spliter = key;
            
            paNode = parent;
        }
        
        public String toString(){
            return "data 是" + String.valueOf(data) +" spliter 是: " + spliter;  
        }
        
        
        public String getPath(){
            StringBuilder sb = new StringBuilder();
            sb.append(spliter);
            TSTNode parent = paNode;
            while(parent !=null){
                sb.append(parent.spliter);
                parent = parent.paNode;
            }
            
            return sb.reverse().toString();            
        }
        
        
    }
    
    private static MyTernarySearchTrie dic = null;
    
    public static MyTernarySearchTrie getInstance(){
        
        if(dic ==null){
            dic = new MyTernarySearchTrie("WordList.txt");
        }
        return dic;
    }
    
    public TSTNode rootNode;
    
    
    public MyTernarySearchTrie(String fileName) {
    
        try {
            FileReader fileReader = new FileReader(fileName);
       
            BufferedReader reader = new BufferedReader(fileReader);
            
            String line;
            
            while((line=reader.readLine())!=null){
                    
                StringTokenizer st =  new StringTokenizer(line,"\t");
                
                String word = st.nextToken();
                
                addWord(word);
            }

        
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    
    public MyTernarySearchTrie() {
    }
    
    //创建一个节点
    public TSTNode createTSTNode(char[] key,int keyLength){
        
        if(key ==null){
            throw new NullPointerException();
        }
        
        if(rootNode ==null){
            rootNode = new TSTNode(key[0], null);
        }
        
        int charIndex = 0;
        
        TSTNode currentNode = rootNode;
        
        while(true){
            //计算两个char之间的差值 继而进行左右下的节点拆分
            int compa = (key[charIndex] - currentNode.spliter);
            if(compa ==0){
                charIndex++;
                if(charIndex ==keyLength){
                    return currentNode;
                }
                if(currentNode.eqNode == null){
                    currentNode.eqNode  = new TSTNode(key[charIndex], currentNode);
                }
                
                currentNode = currentNode.eqNode;
            }else if(compa <0){
                
                if(currentNode.loNode ==null){
                    currentNode.loNode = new TSTNode(key[charIndex], currentNode);
                    
                }
                currentNode = currentNode.loNode; 
            }else{
                
                if(currentNode.hiNode ==null){
                    
                    currentNode.hiNode  =new TSTNode(key[charIndex],currentNode);
                }
                
                currentNode = currentNode.hiNode;
            }
            
        }
    }
    //添加词语到字典树中
    public void addWord(String word) {
        char[] key = word.toCharArray();
        
        int keyLength = word.length();
        
        TSTNode currentNode = createTSTNode(key, keyLength);
        
        currentNode.data = key;
        
    }
    
    public int matchNum(int start,char[] key,int length){
        int i = start;
        while(i<length){
            char c = key[i];
            if(c >='0' && c <='0'){
                i++;
            }else{
                break;
            }
        }
        return i;
    }
    
    public int mactchEnglish(int start,char[] key,int length){
        int i = start;
        while(i<length){
            char c =key[i];
            if(c >='a' && c<='z' || c>='A' && c <='Z'){
                i++;
            }else{
                break;
            }
        }
        return i;
    }
    
    //最大正向匹配
    public char[] matchLong(char[] key,int offset,int length){
        
        char[] ret =null;
        
        int numEnd = matchNum(offset,key,length);
        
        if(numEnd>offset){
            char[] num = new char[numEnd - offset];
            System.arraycopy(key, offset, num, 0, num.length);
            return num;
        }
        
        int englishEnd = mactchEnglish(offset, key, length);
        
        if(englishEnd > offset){
           char[] english =  new char[englishEnd -offset];
           System.arraycopy(key, offset, english, 0, english.length);
           return english;
        }
        
        TSTNode currentNode = rootNode;
        
        int charIndex = offset;
        
        while(true){
            if(currentNode == null){
                return ret;
            }
            int charComp = key[charIndex] -currentNode.spliter;
            
            if(charComp ==0){
                
                charIndex++;
                if(currentNode.data !=null){
                    ret = currentNode.data;//候选词语
                }
                if(charIndex ==length){
                    return ret;//正确匹配
                }
                currentNode = currentNode.eqNode;
            }else if(charComp <0){
                currentNode  = currentNode.loNode;
            }else{
                currentNode = currentNode.hiNode;
            }
            
        }
    }
    
    //生成二进制文件1
    public void compileDic(File binFile) {
        
    }
    //加载二进制数据
    public void loadBinaryDataFile(File binFile) {
        
    }

}
