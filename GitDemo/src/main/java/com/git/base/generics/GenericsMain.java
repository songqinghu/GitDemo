package com.git.base.generics;

public class GenericsMain {

	public static void main(String[] args) {
		LikeAction like = new LikeAction();
		like.setLikeEat("肉");
		like.setLikeAddress("日本东京看东京热");
		like.setLikeSport("俯卧撑和仰卧起坐");
		GenericsForExtends<LikeAction> g1 = new GenericsForExtends<>(like);
		
		g1.getInfo();
		InstanceInfo instance = new InstanceInfo();
		
		instance.setAge("18");
		instance.setName("昌军");
		instance.setGender("女");
		GenericsForExtends<InstanceInfo> g2 = new GenericsForExtends<>(instance);
		
		g2.getInfo();
		
		
	}
}
