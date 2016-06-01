package com.git.base.io.stream.bufferread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 录入数据 获取对应的数据类型
 * <p>Title: InputData.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年6月1日下午11:03:24
 * @version 1.0
 */
public class InputData {

	private BufferedReader read = null;
	
	private boolean end = false;
	
	private String endString ;
	
	public InputData(String endString){
		read = new BufferedReader(new InputStreamReader(System.in));
		this.endString = endString;
	}
	
	
	public String  getInfo(String info){
		
		//获取录入的信息
		String temp =null;
		
		System.out.println(info);//提示录入信息
		
		try {
			temp = read.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	
	public int getInt(String info,String err){
		//将输入的信息变为数字 提示信息  输入错误的提示信息
		boolean flag = true;
		int result = 0;
		while(flag){
			
			String temp = getInfo(info);
			if(endString.equals(temp)){
				end = true;
				break;
			}
			if(temp.matches("^\\d+$")){//正则判断是否符合要求
				result = Integer.parseInt(temp);
				flag = false;
			}else{
				System.out.println(err);
			}
		}
		return result;
	}


	public boolean isEnd() {
		return end;
	}
	
	
	
}
