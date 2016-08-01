package com.git.utils;

import java.io.Serializable;
import java.util.List;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @author liuyuxin
 */
public class EcpUser implements Serializable {

    private static final long serialVersionUID = 1050194209847746416L;

    @Field
    private String userId;
    @Field
    private String userPic;
    @Field
    private String userName;
    @Field
    private Long createTime;
    @Field
    private Integer topicCount=0;
    @Field
    private String phoneId;
    @Field
    private List<String> friendList;
    @Field
    private List<String> groupList;

    /**
     * `expert_audit_status` tinyint(1) DEFAULT '0' COMMENT '达人审核状态
     * 0表示未审核，1表示审核中，2表示审核成功，3表示审核失败',
     */
    @Field
    private Integer status;

    @Field
    private String userLocation;
    /**
     * 冗余存储
     */
    @Field
    private String imId;

    /**
     * `type` tinyint(1) DEFAULT NULL COMMENT '用户类型 0:管理员 1:买家 2:XPOP商家 3:达人美店
     * 5:后台运营 6:普通员工 7:门店员工 8:促销员工',
     */
    @Field
    private Integer type;

    @Field
    private Long followerCount = 0l;

    @Field
    private Double weight = 0.0;

    @Field
    private String user_sign;// 用户签名

    private String dist;

    private Double latitude;

    private Double longtitude;

    public enum Column {
        userId, userName, status, userPic, groupList, friendList, userLocation, dist, createTime
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getTopicCount() {
        return topicCount;
    }

    public void setTopicCount(Integer topicCount) {
        this.topicCount = topicCount;
    }

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    public List<String> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<String> friendList) {
        this.friendList = friendList;
    }

    public List<String> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<String> groupList) {
        this.groupList = groupList;
    }

    public String getImId() {
        return imId;
    }

    public void setImId(String imId) {
        this.imId = imId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUser_sign() {
        return user_sign;
    }

    public void setUser_sign(String user_sign) {
        this.user_sign = user_sign;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Long getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(Long followerCount) {
        this.followerCount = followerCount;
    }

}
