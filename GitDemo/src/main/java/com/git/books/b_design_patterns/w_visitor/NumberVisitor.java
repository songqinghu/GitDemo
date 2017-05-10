package com.git.books.b_design_patterns.w_visitor;
/**
 * <p>Title: NumberVisitor.java</p>
 * <p>Description: 数量计算访问者</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2017年3月29日下午9:51:47
 * @version 1.0
 */
public class NumberVisitor implements ShoppingVisitor {

	private int bookSize ;
	
	private int appliancesSize;
	
	public NumberVisitor() {
		bookSize = 0;
		appliancesSize = 0;
	}
	
	public double getNumber(){
		return bookSize * 0.67 + appliancesSize*1.1;
	}
	
	
	@Override
	public void visitorBook(Books books) {
		bookSize++;
	}

	@Override
	public void visitorElectricAppliances(ElectricAppliances appliances) {
		appliancesSize++;
	}

}
