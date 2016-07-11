package com.git.base.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1.将用户在控制台上输出的5个数字按照大小顺序存入到
 * D:\\xx.txt中,并读出显示在控制台上
 * <p>Title: NumberSort.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年7月2日下午2:33:43
 * @version 1.0
 */
public class NumberSort {

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader input =   
                new BufferedReader (new InputStreamReader (System.in)   ); 
		
		System.out.println("请输入要排序的数字,使用逗号分隔,回车结束输入!");

		String line = input.readLine();
		System.out.println("您输入的内容为:"+line);
		
		String[] numbers = line.split(",");
		int[] nums = new int[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			nums[i]= Integer.parseInt(numbers[i]);
		}
		
		Arrays.sort(nums);//从小到大

		int[] finals = new int[nums.length];
		
		for (int i = 0; i<nums.length; i++) {
			finals[finals.length-i-1] = nums[i];
		}
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < finals.length; i++) {
			sb.append(finals[i]);
			if(i!=finals.length-1){
				sb.append(" ");
			}
		}
		
		System.out.println("排序后结果为: "+ sb.toString());
		
		BufferedWriter bufw =  
                new BufferedWriter (new OutputStreamWriter(new FileOutputStream(new File("D:\\xx.txt"))));  
		
		bufw.write(sb.toString());
		
		bufw.close();
		
	}
	
	
	
}
