package com.git.books.a_lucene_java.aho_corasick.search.pagerank;

import Jama.Matrix;

/**
 * 
 * @Description: java实现pagerank计算网页重要性demo
 * @author: songqinghu
 * @date: 2017年2月14日 下午2:44:09
 * Version:1.0
 */
public class PageRankDemo {

    private static double alpha = 0.85;//阻尼系数
    
    public static void main(String[] args) {
        
        //随机矩阵 
        double[][] webImages = {
                                 {0,0,0.5d,1d},
                                 {1d,0,0,0},
                                 {0,0.5d,0,0},
                                 {0,0.5d,0.5d,0}
                               };
        //初始PR值 默认都为1
        double[][] webInitPR = {{1d},{1d},{1d},{1d}};
        //最小PR值
        double[][] webMinimumPR = {{0.000001d},{0.000001d},{0.000001d},{0.000001d}};  
        
        int n = webImages.length;  
        
        Matrix s = new Matrix(webImages);//源矩阵  

        Matrix pageRank = new Matrix(webInitPR);//page rank初始值  

        Matrix minimum = new Matrix(webMinimumPR);//极小值  

        Matrix u=new Matrix(n,n,1.0d);//单元矩阵  

        Matrix g=s.times(alpha).plus(u.times((1-alpha)/n));  
        
        g.print(4, 10);
        
        
        /* 
        
         * 开始迭代计算适合的pageRank值。（也就是求矩阵g，特征值为1 的特征向量pageRank。ps：近似值） 

         */  

        Matrix pageRankPre = pageRank;  

        pageRank = g.times(pageRank);  

        pageRank.print(4, 3);
        
        int iterator =1;  

        
        while(true){  

                    if(compareAbs(minimum,pageRankPre.minus(pageRank))){  

                            break;  

                    }else{  
                            
                            pageRankPre = pageRank;  

                            pageRank = g.times(pageRank);  
                            
                            
                            
                            iterator ++;  
                            

                          
                   }  

        }  

        System.out.print("倒数第一次迭代结果：");  

        pageRankPre.print(4, 7);  

        System.out.print("最后结果：");  

        pageRank.print(4, 7);  

        System.out.print("迭代次数：" + iterator);  

    }  

    /* 
    
     * 同阶矩阵，比较对应元素的的绝对值。如果对任意的i,j=1,2,...,n。都有|a(ij)|>|b(ij)|则返回true,否则返回false 
    
     */  
    
    public static boolean compareAbs(Matrix a,Matrix b){  

        boolean flag = true;  

        for(int i=0;i<a.getRowDimension();i++){  

                for(int j=0;j<a.getColumnDimension();j++){  

                        if(Math.abs(a.get(i, j))<=Math.abs(b.get(i, j))){  

                                flag = false;break;  

                        }  

                }  

        }  

        return flag;  

    }
    
    
    
}
