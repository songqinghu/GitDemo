package com.git.ocr;
/**
 * 
 * @Description: 将图片进行区域分隔
 * @author: songqinghu
 * @date: 2016年12月6日 下午6:58:33
 * Version:1.0
 */
public class CharRange {

    public CharRange(int x, int y, int width, int height) {
    	
    	this.x = x;
    	this.y = y;
    	this.width = width;
    	this.height = height;
	}

	int x ;//横坐标位置
    
    int y;//纵坐标位置
    
    int width;//宽度
    
    int height;//高度
    
    
}
