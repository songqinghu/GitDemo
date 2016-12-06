package com.git.ocr;
/**
 * libsvm训练数据样本
 * <p>Title: SimpleData.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年12月6日下午9:21:51
 * @version 1.0
 */
public class SimpleData {

	public SimpleData(String string, int width, int height) {
		
		this.width = width;
		this.height = height;
	}

	protected  boolean grid[][];//用布尔二维数组存储的采样数据
	
	public double ratio;//宽高比 即 width/height
	
	protected String letter;//对应字符串或者字符
	
	public int width;
	
	public int height;
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean[][] getGrid() {
		return grid;
	}

	public void setGrid(boolean[][] grid) {
		this.grid = grid;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public void setData(int x, int y, boolean b) {
		
	}
	
}
