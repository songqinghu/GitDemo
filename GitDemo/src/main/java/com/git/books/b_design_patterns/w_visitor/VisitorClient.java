package com.git.books.b_design_patterns.w_visitor;

import java.util.ArrayList;

/**
 * <p>Title: VisitorClient.java</p>
 * <p>Description: 访问者测试类</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2017年3月29日下午10:08:09
 * @version 1.0
 */
public class VisitorClient {

	public static void main(String[] args) {
		
		ArrayList<Commodity> commodities = new ArrayList<Commodity>();
		
		commodities.add(new Books(100f));
		commodities.add(new Books(120f));
		commodities.add(new Books(40f));
		
		commodities.add(new ElectricAppliances(3000f));
		commodities.add(new ElectricAppliances(2300f));
		commodities.add(new ElectricAppliances(1499f));
		
	
		PriceVisitor priceVisitor = new PriceVisitor();
		
		NumberVisitor numberVisitor = new NumberVisitor();
		
		for (Commodity commodity : commodities) {
			commodity.visitor(priceVisitor);
			commodity.visitor(numberVisitor);
		}
		
		System.out.println("size : " + numberVisitor.getNumber());
		System.out.println("price : " + priceVisitor.getPrice());
		
		
	}
	
}
