package com.git.base.io.stream;

import java.io.BufferedReader;
import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.io.Serializable;

public class SequenceDemo implements Serializable  {

    private transient String out;
    public static void main(String[] args) throws IOException {
        
        FileInputStream one = new FileInputStream(new File("E:"+File.separator+"lucene"+File.separator+"file"+File.separator+"AlchemyAPIAnnotator-NOTICE.txt"));
        FileInputStream two = new FileInputStream(new File("E:"+File.separator+"lucene"+File.separator+"file"+File.separator+"aopalliance-LICENSE-PD.txt"));
        
        SequenceInputStream in = new SequenceInputStream(one, two);
        
        FileOutputStream out = new FileOutputStream(new File("E:"+File.separator+"lucene"+File.separator+"file"+File.separator+"test.txt"));
        
        int temp =-1;
        while((temp = in.read())!=-1){
            out.write(temp);
        }
        
        in.close();
        out.close();
        
    }
}
