package com.scl.auth.shiro.token;

import com.scl.auth.shiro.RequestType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * 组合Shiro AuthenticationToken，携带请求类型
 * 经过JWtFilter的所产生的token，都是该类型的token
 *
 * @author shengchenglong
 */
@Data
@AllArgsConstructor
public class CurrentAuthenticationToken implements AuthenticationToken {

    private AuthenticationToken token;

    private RequestType requestType;

    @Override
    public Object getPrincipal() {
        return this.token.getPrincipal();
    }

    @Override
    public Object getCredentials() {
        return this.token.getCredentials();
    }
}
