package com.git.books.b_design_patterns.w_visitor;
/**
 * <p>Title: Commodity.java</p>
 * <p>Description: 商品</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2017年3月29日下午9:53:17
 * @version 1.0
 */
public interface Commodity {

	public   float  price();
	
	public   void  visitor(ShoppingVisitor visitor);
	
}
