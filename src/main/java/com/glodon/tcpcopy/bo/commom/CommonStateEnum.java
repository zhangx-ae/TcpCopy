package com.glodon.tcpcopy.bo.commom;

import org.apache.commons.lang.enums.ValuedEnum;

/**
 * Created by zhangxin on 2016/11/13.
 */
public class CommonStateEnum extends ValuedEnum {

    protected CommonStateEnum(String name, int value) {
        super(name, value);
    }

    public static int NORMAL = 1;
    public static int DISABLED = 2;
    public static int DELETED = 0;

    public static final CommonStateEnum NORMAL_ENUM = new CommonStateEnum("NORMAL", NORMAL);
    public static final CommonStateEnum DISABLED_ENUM = new CommonStateEnum("DISABLED", DISABLED);
    public static final CommonStateEnum DELETED_ENUM = new CommonStateEnum("DELETED", DELETED);



}
