package com.glodon.security.realm;

import com.glodon.tcpcopy.bo.user.RoleEnum;
import com.glodon.tcpcopy.bo.user.User;
import com.glodon.tcpcopy.service.user.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasAuthenticationException;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.cas.CasToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.TicketValidationException;
import org.jasig.cas.client.validation.TicketValidator;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * Created by zhangxin on 2016/11/9.
 */
public class GlodonCasRealm extends CasRealm {

    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        User user = (User) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<String>();
        roles.add(user.getUserType().getName());
        //临时指定为普通用户
        roles.add(RoleEnum.ROLE_USER_ENUM.getName());
        authorizationInfo.setRoles(roles);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        CasToken casToken = (CasToken) token;
        if (casToken == null) {
            return null;
        }
        String ticket = casToken.getCredentials().toString();
        if (null == ticket) {
            return null;
        }

        TicketValidator ticketValidator = ensureTicketValidator();

        try {
            Assertion casAssertion = ticketValidator.validate(ticket, getCasService());
            AttributePrincipal casPrincipal = casAssertion.getPrincipal();

            String userId = casPrincipal.getName();
            Map attributes = casPrincipal.getAttributes();
            casToken.setUserId(userId);
            String rememberMeAttributeName = getRememberMeAttributeName();
            String rememberMeStringValue = (String) attributes.get(rememberMeAttributeName);
            boolean isRemember = rememberMeAttributeName != null && Boolean.parseBoolean(rememberMeStringValue);

            if (isRemember) {
                casToken.setRememberMe(true);
            }


            User user = userService.getUserByLoginName(userId);
            if(user == null){
                user = new User();
                user.setuId(UUID.randomUUID().toString());
                user.setUserName(userId);
                user.setUserType(RoleEnum.ROLE_USER_ENUM);
                userService.addUser(user);
            }

//            User user = new User();
//            user.setUserName(userId);
//            user.setUserType(RoleEnum.ROLE_USER_ENUM);

            return new SimpleAuthenticationInfo(user, ticket, getName());

        } catch (TicketValidationException e) {
            throw new CasAuthenticationException("Unable to validate ticket [" + ticket + "]", e);
        }
    }
}
