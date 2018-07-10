package com.scl.auth.shiro.token;

import com.scl.auth.shiro.RequestType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

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
