package com.git.base.io.stream.bufferread;

/**
 * 输入数字 进行加法计算
 * <p>Title: InputNumberAddDemo.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年6月1日下午11:08:36
 * @version 1.0
 */
public class InputNumberAddDemo {

	public static void main(String[] args) {
		
		//addNumber();
		menu();
	}
	
	//无限累加
	public static void addNumber(){
		
		System.out.println("进入无限累加,如要结束,请输入: break");
		
		InputData in = new InputData("break");
		
		StringBuffer buffer = new StringBuffer();
		int init = 0;
		while(true){
			int num = in.getInt("请输入数字,结束请输入 break", "输入格式错,请重新输入!"); 
			if(in.isEnd()){
				break;
			}
			init +=num;
			buffer.append(num+"+");//多了一个+号
		}
		System.out.println(buffer.toString().substring(0,buffer.toString().length()-1)+"="+init);
	}
	
	//类目选择
	public static void menu(){
		InputData in = new InputData("exit");
		boolean flag =true;
		while(flag){
			System.out.println();
			System.out.println("=====图书管理系统=========");
			System.out.println("=====[1],添加图书=========");
			System.out.println("=====[2],修改图书=========");
			System.out.println("=====[3],删除图书=========");
			System.out.println("=====[4],查询图书=========");
			System.out.println("=====[0],退出系统=========");
			System.out.println();
			int num = in.getInt("请输入数字,选择相应操作", "输入信息有误,请重新输入!");
			
			switch (num) {
			case 1:
				System.out.println("添加图书成功!");
				break;
			case 2:
				System.out.println("修改图书成功!");
				break;
			case 3:
				System.out.println("删除图书成功!");
				break;
			case 4:
				System.out.println("查询图书成功!");
				break;
			case 0:
				System.out.println("正在退出系统,谢谢使用!");
				flag = false;
				break;
			default:
				System.out.println("输入命令有误,请重新输入!");
				break;
			}
			
			
		}
		
	}
	
	
	
	
}
