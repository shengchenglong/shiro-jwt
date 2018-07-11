package com.scl.auth.shiro.realm;

import com.scl.auth.bean.User;
import com.scl.auth.service.UserService;
import com.scl.auth.shiro.RequestType;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.security.auth.login.AccountNotFoundException;

/**
 * 管理端登录
 *
 * @author shengchenglong
 */
@Component
public class ManageLoginRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService = new UserService();

    @Override
    public String getName() {
        return RequestType.MANAGE_LOGIN.name();
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        User user = userService.getUser(username);

        if (null == user) {
            throw new UnknownAccountException();
        }

        String password = new String((char[]) token.getCredentials());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, this.getName());
        return authenticationInfo;
    }

}
