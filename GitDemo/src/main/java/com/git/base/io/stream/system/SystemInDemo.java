package com.git.base.io.stream.system;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SystemInDemo {

	public static void main(String[] args) throws IOException {
		
		StringBuilder builder = new StringBuilder();
		InputStream in = System.in;
		int temp = -1;
		System.out.println("请输入要输入的信息,按回车键结束!");
		while ((temp =in.read())!=-1) {
	
			char c = (char)temp;
			
			if(c == '\n'){
				break;
			}
			builder.append((char)temp);
		}
		System.out.println("录入结束!");
		
		System.out.println("录入信息为: " + builder.toString());
		File file = new File("D:\\logs"+File.separator+ "temp.txt");
		if(!file.exists()){
			
		}
		FileOutputStream out = new FileOutputStream(file,true);
		
		out.write(builder.toString().getBytes(), 0, builder.toString().getBytes().length);
		
		
		out.close();
		
	}
}
