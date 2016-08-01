package com.git.digget;

import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.git.utils.EcpUser;

public class JsonTest<T> {

    public static void main(String[] args) {
        
                    List<String> fakeGroupMsgs=new LinkedList<>();  //根据topicMsgs制造出的伪groupMsgs
                    JSONObject fakeGroupMsgObj= new JSONObject();
                    fakeGroupMsgObj.put("id", "1");
                    fakeGroupMsgs.add(fakeGroupMsgObj.toString());
                    for (String string : fakeGroupMsgs) {
                        
                        String groupId = net.sf.json.JSONObject.fromObject(string).getString("id");
                        System.out.println(groupId);
                    }
    }
    
    public static Object getBeans(Object t){
        String text = "{\"success\":true,\"code\":200,\"data\":[{\"id\":3,\"nickname\":\"国美在线\",\"displayName\":\"国美在线\",\"passwd\":\"db16@0aa27fe12819fe1a453c\",\"mobile\":\"13511111111\",\"email\":\"gome@yolo24.com\",\"type\":true,\"status\":true,\"outerUserId\":\"3\",\"createdAt\":1418196923000,\"updatedAt\":1452147046000,\"isUserSpreader\":false,\"isSaleSpreader\":false,\"gomeUserExtras\":{\"memberId\":3,\"recommendTime\":1436779402000,\"updateTime\":1457061797000,\"picturePath\":\"T1xaCTB5CT1R4cSCrK.png\",\"createTime\":1436779402000,\"loveLifeAuth\":0,\"userSign\":\"123456000\",\"expertAuditStatus\":false}}]}";
        EcpUser parseObject = JSON.parseObject(text, new TypeReference<Object>() {}.getType()); 
        
        return parseObject;
    }
    
    
}
