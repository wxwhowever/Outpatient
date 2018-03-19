//package com.shiro;
//
//import com.biz.UserBiz;
//import com.dao.UserDao;
//import com.entity.User;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//public class LoginRealm extends AuthorizingRealm{
//
//    @Autowired
//    UserDao userDao ;
//
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//
//        UsernamePasswordToken token1 = (UsernamePasswordToken) token;
//        String username = token1.getUsername();
////      根据用户名查询 出用户
//        User user = userDao.shiroLogin(username);
//        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,user.getPassword(),this.getName());
//        return info;
//    }
//
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
////        获取登录时的用户名
//        User user = (User) principals.getPrimaryPrincipal();
//        List<String> role = new ArrayList<String>();
//        List<Map<String,Object>> permissions;
//        permissions = userDao.queryPower(user.getUid());
//
//        for (Map<String, Object> permission : permissions) {
//            Set<String> strings = permission.keySet();
//            for (String string : strings) {
//                System.out.println(string);
//            }
//        }
//
////        if("admin".equals(name)){
////            role.add("管理员");
////        }
////        if("wxw".equals(name)){
////            role.add("挂号分诊员");
////        }
////        if("zy".equals(name)){
////            role.add("门诊治疗员");
////        }
////        if("xjy".equals(name)){
////            role.add("药品管理员");
////        }
//
//
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//
//
//        return null;
//    }
//}
