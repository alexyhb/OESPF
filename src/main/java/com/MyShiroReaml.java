package com;

import com.pojo.User;
import com.service.ShiroService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.List;

public class MyShiroReaml extends AuthorizingRealm {
    private ShiroService shiroService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        /**
         *
         * 流程
         * 1.根据用户user->2.获取角色id->3.根据角色id获取权限permission
         */
        //方法一：获得user对象
        User user=(User)pc.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取permission
        if(user!=null) {
            List<Permission> permissionsByUser = shiroService.getPermissionsByUser(user);
            if (permissionsByUser.size()!=0) {
                for (Permission p: permissionsByUser) {

//                    info.addStringPermission(p.getUrl());
                }
                return info;
            }
        }

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
    public ShiroService getShiroService() {
        return shiroService;
    }

    public void setShiroService(ShiroService shiroService) {
        this.shiroService = shiroService;
    }

}
