package com.git.pinyin;


import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map.Entry;


public class PYSeparator implements Separator {
	Dict dict;
	public PYSeparator(Dict d){
		this.dict = d;
	}
	public ArrayList<String> separate(String str){
		ArrayList<String> ret = new ArrayList<String>();
		if(dict.costs(str) != 2){
			ret.add(str);
			return ret;
		}	
		int size = str.length();
		int[][] vMat = new int[size][size], posMat = new int[size][size];//posMat��¼�ָ���ǰ��һ����ĸ��λ��
		int row, col;
		for(int i = 0; i < size; i++){
			int ceil = size - i;
			col = i;
			row = 0;
			for(int j = 0; j < ceil; j++){
				if(row == col){
					vMat[row][col] = dict.costs("" + str.charAt(row));
					posMat[row][col] = row;
				}
				else{
					int min = Integer.MAX_VALUE, pos = row;

					for(int t = row; t < col; t++){
						int value = vMat[row][t] + vMat[t + 1][col] + dict.costs(str.substring(row, col + 1));
						if(value <= min){
							min = value;
							pos = t;
						}
					}
					vMat[row][col] = min;
					posMat[row][col] = pos;
				}
				col++;
				row++;
			}
		}
		
		//debug
		//for(int i = 0; i < size; i++){
		//	for(int j = 0; j < size; j++){
		//		System.out.print(vMat[i][j] + "/" + posMat[i][j] + "  ");
		//	}
		//	System.out.println();
		//}
		
		LinkedList<Entry<Integer, Integer>> splits = new LinkedList<Entry<Integer, Integer>>();
		splits.add(new SimpleEntry<Integer, Integer>(0, str.length() - 1));
		while(!splits.isEmpty()){
			Entry<Integer, Integer> span = splits.pollFirst();
			int st = span.getKey(), end = span.getValue();
			String nowSt = str.substring(st, end + 1);
			if(dict.costs(nowSt) != 2){
				ret.add(nowSt);
				continue;
			}
			int sp = posMat[st][end];
			if(sp + 1 < end)
				splits.addFirst(new SimpleEntry<Integer, Integer>(sp + 1, end));
			if(st < sp)
				splits.addFirst(new SimpleEntry<Integer, Integer>(st, sp));
			
			
			
		}
		
		return ret;
	}
}
