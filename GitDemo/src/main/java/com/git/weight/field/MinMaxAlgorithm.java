package com.git.weight.field;
/**
 * 最小最大规范化算法
 * @author songqinghu
 *
 */
public class MinMaxAlgorithm {

    
    public static Double getValue(double v,double min,double max,double newMin,double newMax ){
        return (v-min)/(max-min)*(newMax-newMin) + newMin;
    }
    
}
