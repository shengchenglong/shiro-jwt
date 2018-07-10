package com.scl.auth.shiro.realm;

import com.scl.auth.shiro.RequestType;
import com.scl.auth.shiro.token.CurrentAuthenticationToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

import java.util.Collection;

public class CustomModularRealmAuthenticator extends ModularRealmAuthenticator {

    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 判断getRealms()是否返回为空
        assertRealmsConfigured();
        // 强制转换回自定义的CustomizedToken
        CurrentAuthenticationToken token = (CurrentAuthenticationToken) authenticationToken;
        // 类型
        RequestType requestType = token.getRequestType();

        // TODO map multiple configurable realm
        for (Realm realm : this.getRealms()) {
            if (requestType.name().equals(realm.getName())) {
                return doSingleRealmAuthentication(realm, token.getToken());
            }
        }
        return null;
    }

    // TODO map realm
    @Override
    public void setRealms(Collection<Realm> realms) {
        super.setRealms(realms);
    }
}
