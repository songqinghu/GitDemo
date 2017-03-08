package com.git.books.b_design_patterns.l_proxy.b;

/** 
 * @Description: 保护代理用户交互代理类 用来完成验证保护工作及代理转发
 * @author: songqinghu
 * @date: 2017年3月8日 下午5:44:25
 * Version:1.0
 */
public class ProtectionAccountInfoProxy implements AccountInfoProxy {
    
    private AccountInfoProxy accountInfo;
    
    public ProtectionAccountInfoProxy(AccountInfoProxy accountInfo) {
        this.accountInfo = accountInfo;
    }
    
    @Override
    public void showUserInfo(String userId) {
        if(UserInfoCheck.getInstance().check(userId)){
            accountInfo.showUserInfo(userId);
        }else{
            System.out.println("You do not have access rights!");
        }
    }

}


class UserInfoCheck{
    
    private UserInfoCheck() {
        //write some thing
    }
    //内部类单例
    private static class AccountInner{
        private static  UserInfoCheck check = new UserInfoCheck();
    }
    
    public static UserInfoCheck getInstance(){
        return AccountInner.check;
    }
    
    public boolean check(String userId){
        if(UserToken.Admin.toString().equals(userId)){
            return true;
        }else{
            return false;
        }
           
    }
}

enum UserToken{
    Admin,ReadOnly,Tourist
}

