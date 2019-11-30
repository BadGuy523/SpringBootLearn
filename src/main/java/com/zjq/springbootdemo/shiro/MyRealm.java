package com.zjq.springbootdemo.shiro;

import com.zjq.springbootdemo.mapper.UserMapper;
import com.zjq.springbootdemo.model.Permission;
import com.zjq.springbootdemo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: Realm
 * @author: BadGuy
 * @date: 2019-11-27 20:24
 **/
@Slf4j
public class MyRealm extends AuthorizingRealm {

    @Resource
    UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.getPrimaryPrincipal();
        User user = userMapper.getUserInfo(userName);
        //对当前用户赋予角色和权限
        List<String> roles = new ArrayList<>();
        List<String> permissions = new ArrayList<>();
        roles.add(user.getRole().getCode());
        for (Permission permission : user.getRole().getPermissions()) {
            permissions.add(permission.getCode());
        }
        //将角色和权限组装进授权信息中
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roles);
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        String password = new String((char[])authenticationToken.getCredentials());
        boolean canLogin = true;
        if (!canLogin) {
//            throw new UnknownAccountException();  //用户名错误
            throw new IncorrectCredentialsException();  //密码错误
        }

        return new SimpleAuthenticationInfo(userName,password,getName());
    }
}
