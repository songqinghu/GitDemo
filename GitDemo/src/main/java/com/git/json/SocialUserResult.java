package com.git.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * http://wiki.intra.gomeplus.com/pages/viewpage.action?pageId=13828565
 * @Description: TODO
 * @author: songqinghu
 * @date: 2016年7月4日 下午5:32:14
 * Version:1.0
 */
public class SocialUserResult implements Serializable{

    private static final long serialVersionUID = -2315551790013704539L;
    
    private List<SimpleUser> users = new ArrayList<SimpleUser>();

    public List<SimpleUser> getUsers() {
        return users;
    }

    public void setUsers(List<SimpleUser> users) {
        this.users = users;
    }

    
}
//BS 要求返回如下信息--其余信息他们自己填充
//{
//    "message": "",
//    "data": {
//        "users": [
//            {
//                "userId": 321,
//            },
//            {
//                "userId": 322,
//            }
//        ]
//    }
//}