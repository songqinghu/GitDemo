package com.git.ocr;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.PixelGrabber;
import java.util.ArrayList;

import com.alibaba.druid.sql.dialect.oracle.ast.clause.SampleClause;

/**
 * 
 * <p>Title: Entry.java</p>
 * <p>Description: 切割字符且把大小归一化
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年12月6日下午8:43:22
 * @version 1.0
 */
public class Entry {

	
	public static final int DOWNSAMPLE_WIDTH = 12;//样本数据宽度
	
	public static final int DOWNSAMPLE_HEIGHT = 18;//样本数据高度
	
	protected Image entryImage;// 存储检测的图片
	
	protected Graphics entryGraphics;//处理图形图像
	
	protected int pixelMap[];//存储图像像素
	
	//水平扫描图像且进行像素检测
	protected boolean hLineClear(int x,int w,int y) {
		
		int totalWidth = entryImage.getWidth(null);
		
		for (int i = x; i <=w; i++) {
			if(pixelMap[(y*totalWidth)+i]!=-1){
				return false;
			}
		}
		return true;
	}
	
	
	//垂直扫描图像且进行像素检测
	protected boolean vLineClear(int x) {
		
		int w = entryImage.getWidth(null);
		int h = entryImage.getHeight(null);
		
		for (int i = 0; i < h; i++) {
			if(pixelMap[(i*w)+x]!=-1){
				return false;
			}
		}
		return true;
	}
	
	
	//找到水平扫描时的上边界和下边界
	void findVBound(CharRange cr){
		
		for (int i = 0; i < cr.height; i++) {
			if(!hLineClear(cr.x, cr.width, i)){
				cr.y=i;
				break;
			}
		}
		
		for (int i = cr.height -1; i >=0; i--) {
			
			if(!hLineClear(cr.x, cr.width, i)){
				cr.height=i;
				break;
			}
		}
		
		
	}
	
	//找到垂直扫描时的左边界和右边界
	protected ArrayList<CharRange> findHBounds(int w,int h) {
		
		ArrayList<CharRange> bounds = new ArrayList<CharRange>();
		
		int begin =0;
		
		int end = w;
		
		boolean lastState = false;
		
		boolean curState = false;
		
		for (int i = 0; i < w; i++) {
			
			if(vLineClear(i)){
				System.out.println("find blank : " + i);
				curState = false;
			}else{
				curState = true;
			}
			
			if(!lastState && curState){
				begin =i;
			}else if(lastState && !curState){
				end = (i-1);
				CharRange cr = new CharRange(begin,0,end,h);
				bounds.add(cr);
			}
			lastState = curState;
			
		}
		
		if(curState){
			CharRange cr = new CharRange(begin, 0, w-1, h);
			bounds.add(cr);
		}
		return bounds;
	}
	
	
	//发现图像边界
	
	protected ArrayList<CharRange> findBounds(int w,int h ) {
		
		ArrayList<CharRange> bounds = findHBounds(w, h);
		
		for (CharRange cr : bounds) {
			findVBound(cr);
		}
		return bounds;
	}
	
	//对样本数据进行采样,归一化
	public ArrayList<SimpleData> downSimple() throws InterruptedException{
		
		int w = entryImage.getWidth(null);
		int h = entryImage.getHeight(null);
		
		ArrayList<SimpleData> samples = new ArrayList<SimpleData>();
		
		PixelGrabber grabber = new PixelGrabber(entryImage, 0, 0, w, h,true);
		
		grabber.grabPixels();
		
		pixelMap = (int[]) grabber.getPixels();
		
		ArrayList<CharRange> bounds = findBounds(w, h);
		
		for (CharRange cr : bounds) {
			
			SimpleData data = new SimpleData("?",DOWNSAMPLE_WIDTH,DOWNSAMPLE_HEIGHT);
			System.out.println(cr);
			double ratioX = (double)(cr.width -cr.x +1)/(double)DOWNSAMPLE_WIDTH;
			double ratioY = (double)(cr.height -cr.y +1)/(double)DOWNSAMPLE_HEIGHT;
			for (int y = 0; y < data.getHeight(); y++) {
				for (int x = 0; x < data.getWidth(); x++) {
					if(downSampleQuadrant(x, y, ratioX, ratioY, cr.x, cr.y)){
						data.setData(x,y,true);
					}else{
					    data.setData(x,y,false);
					}
				}
			}
			data.ratio = (double)(cr.width - cr.x +1)/(double)(cr.height - cr.y +1);
			data.ratio = (data.ratio -1)/4;
			samples.add(data);
		}
		return samples;
	}
	
	
	//在样本数据指定的范围内进行像素扫描
	protected boolean downSampleQuadrant(double x,double y,double ratioX,double ratioY, double downSimpleLeft,double downSimpleTop) {
		
		int w = entryImage.getWidth(null);
		
		int startX = (int) (downSimpleLeft + (x*ratioX));
		
		int startY = (int) (downSimpleTop + (y*ratioY));
		
		int endX = (int) (startX + ratioX);
		
		int endY = (int) (startY + ratioY);
		
		for (int yy = startY; yy <= endY; yy++) {
			
			for (int xx = startX; xx <= endX; xx++) {
				int loc = xx+(yy*w);
				if(pixelMap[loc]!=-1){
					return true;
				}
			}
			
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
