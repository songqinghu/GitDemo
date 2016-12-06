package com.git.ocr;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import libsvm.svm;
import libsvm.svm_parameter;
import libsvm.svm_problem;

/**
 * 
 * @Description: 图像识别测试类
 * @author: songqinghu
 * @date: 2016年12月6日 下午4:34:40
 * Version:1.0
 */
public class OCRTest {

    public static void main(String[] args) {
        
        String imageFile = "E:\\java\\img\\svm_03.jpg";
        int[] imgGray = getImgGray(imageFile);
        
    }

    
    
    
    
    
    
    /**
     * 
     * @描述：统计图书的灰度直方图 --二极化 判断黑白
     * @param imageFile 要识别的图片绝对路径
     * @return void
     * @exception
     * @createTime：2016年12月6日
     * @author: songqinghu
     */
    public static int[] getImgGray(String imageFile){
        
        int[] grayValues;//每个像素对象的灰度值
        
        BufferedImage bi = readImageFromFile(imageFile);
        
        //得到图片的宽和高
        int width = bi.getWidth(null);
        int height = bi.getHeight(null);
        
        //读取像素
        int[] pixels = new int[width * height];
        bi.getRGB(0, 0, width, height, pixels, 0, width);
        
        //计算每个像素的灰度且保存下来
        grayValues = new int[width * height];
        for (int i = 0; i < width * height; i++) {
            
            grayValues[i] = getGray(pixels[i]);
            
        }
        
        //存放每种灰度的出现次数
        int[] hist = new int[256];
        
        for (int i = 0; i < grayValues.length; i++) {
            
            hist[grayValues[i]]++;//统计每种灰度出现的次数,得到直方图
            
        }
        
        return hist;
    }
    
    /**
     * @描述：读取图片到流中
     * @param imageFile
     * @return BufferedImage
     * @exception
     * @createTime：2016年12月6日
     * @author: songqinghu
     */
    private static BufferedImage readImageFromFile(String imageFile) {
        
         File image = new File(imageFile);
         
         BufferedImage read = null;
         try {
            read = ImageIO.read(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return read;
    }
    /**
     * 计算图片灰度
     */
    public static  int getGray(int pixel){
        
        int r = (pixel >> 16) & 0xff;
        
        int g = (pixel >> 8 ) & 0xff;
        
        int b = (pixel) & 0xff;
        
        //计算灰度值公式
        int gray = (int) (0.229*r + 0.587*g + 0.114*b);
        
        return gray;
    }
    
    
    
    
}
