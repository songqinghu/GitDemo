package com.git.base.generics;


/**
 * 泛型子类 之 习惯
 * <p>Title: LikeAction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年5月10日下午9:17:46
 * @version 1.0
 */
public class LikeAction implements Info {

	private String likeAddress;
	
	private String likeSport;
	
	private String likeEat;

	public String getLikeAddress() {
		return likeAddress;
	}

	public void setLikeAddress(String likeAddress) {
		this.likeAddress = likeAddress;
	}

	public String getLikeSport() {
		return likeSport;
	}

	public void setLikeSport(String likeSport) {
		this.likeSport = likeSport;
	}

	public String getLikeEat() {
		return likeEat;
	}

	public void setLikeEat(String likeEat) {
		this.likeEat = likeEat;
	}

	@Override
	public String toString() {
		return "LikeAction [likeAddress=" + likeAddress + ", likeSport=" + likeSport + ", likeEat=" + likeEat + "]";
	}
	
}
