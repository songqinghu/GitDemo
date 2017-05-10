package com.git.books.b_design_patterns.w_visitor;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/**
 * <p>Title: PriceVisitor.java</p>
 * <p>Description: 价格计算访问者</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2017年3月29日下午9:51:06
 * @version 1.0
 */
public class PriceVisitor implements ShoppingVisitor {

	private float price;
	
	public PriceVisitor() {
		price = 0;
	}
	
	//特色方法 计算总价格
    public float getPrice(){
    	return price;
    }
	
	
	@Override
	public void visitorBook(Books books) {
		price =price +  books.price() * 0.6f;
	}

	@Override
	public void visitorElectricAppliances(ElectricAppliances appliances) {
		price =price +  appliances.price() * 0.9f;
	}

	
	
	
}
