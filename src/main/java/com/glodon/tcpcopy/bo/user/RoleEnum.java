package com.glodon.tcpcopy.bo.user;

import org.apache.commons.lang.enums.ValuedEnum;

/**
 * Created by zhangxin on 2016/11/9.
 */
public class RoleEnum extends ValuedEnum {
    protected RoleEnum(String name, int value) {
        super(name, value);
    }

    public static int ROLE_ADMIN = 1;
    public static int ROLE_USER = 2;

    public static final RoleEnum ROLE_ADMIN_ENUM = new RoleEnum("ROLE_ADMIN", ROLE_ADMIN);
    public static final RoleEnum ROLE_USER_ENUM = new RoleEnum("ROLE_USER", ROLE_USER);

}
