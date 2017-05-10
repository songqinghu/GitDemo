package com.git.books.b_design_patterns.w_visitor;

public class Books implements Commodity{

	private float price;
	
	public Books(float price) {
		this.price = price;
	}
	
	@Override
	public float price() {
		return price;
	}

	@Override
	public void visitor(ShoppingVisitor visitor) {
		visitor.visitorBook(this);
	}

}
