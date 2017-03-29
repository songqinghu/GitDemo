package com.git.books.b_design_patterns.w_visitor;
/**
 * <p>Title: ShoppingVisitor.java</p>
 * <p>Description:购物访问者 </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2017年3月29日下午9:49:31
 * @version 1.0
 */
public interface ShoppingVisitor {

	public void visitorBook(Books books);
	
	
	public void visitorElectricAppliances(ElectricAppliances appliances);
	
}
