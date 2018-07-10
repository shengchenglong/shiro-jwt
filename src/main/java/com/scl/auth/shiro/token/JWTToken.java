package com.scl.auth.shiro.token;

import com.scl.auth.util.JWTUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

@Data
@AllArgsConstructor
public class JWTToken implements AuthenticationToken {

    private String token;

    @Override
    public Object getPrincipal() {
        return JWTUtil.getUsername(this.token);
    }

    @Override
    public Object getCredentials() {
        return null;
    }
}
