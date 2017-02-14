package com.git.books.a_lucene_java.aho_corasick.search.pagerank;

import Jama.Matrix;

/**
 * 
 * @Description: 矩阵工具类使用demo
 * @author: songqinghu
 * @date: 2017年2月14日 下午3:26:39
 * Version:1.0
 */
public class MatrixDemo {

    public static void main(String[] args) {
        
        //随机矩阵 
        double[][] webImages = {
                                 {0,0,0.5d,1d},
                                 {1d,0,0,0},
                                 {0,0.5d,0,0},
                                 {0,0.5d,0.5d,0}
                               };
        //随机矩阵 
        double[][] web = {
                                 {0,0,0.3d,0.8d},
                                 {1.1d,0,0,0},
                                 {0,0.1d,0,0},
                                 {0,0.2d,1d,0}
                               };
        //创建矩阵
        Matrix demos = new Matrix(webImages);
        Matrix two = new Matrix(web);
        //打印矩阵   每一列宽度  保留小数位数
        //demos.print(4, 3);
        
        //矩阵相加
        demos.plus(two).print(4, 3);
        //矩阵相减
        demos.minus(two).print(4, 3);
        //矩阵相乘
        demos.times(two).print(4, 3);
        
        
        
    }
    
    
    
    
}
