package com.git.books.b_design_patterns.w_visitor;

public class ElectricAppliances implements Commodity{

	private float price;
	
	public ElectricAppliances(float price) {
		this.price = price;
	}
	
	
	@Override
	public float price() {
		
		return this.price;
	}

	@Override
	public void visitor(ShoppingVisitor visitor) {
		visitor.visitorElectricAppliances(this);
	}

}
