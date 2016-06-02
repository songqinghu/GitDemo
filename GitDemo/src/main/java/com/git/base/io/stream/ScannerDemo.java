package com.git.base.io.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PushbackInputStream;
import java.util.Scanner;

public class ScannerDemo {

    public static void main(String[] args) throws FileNotFoundException {
        
        //Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new File("E:\\lucene\\file", "apacheds-all-LICENSE-ASL.txt"));
        while(in.hasNext()){
            String line = in.nextLine();
            System.out.println(line);
        }
        
        System.out.println("END!");
    }
}
