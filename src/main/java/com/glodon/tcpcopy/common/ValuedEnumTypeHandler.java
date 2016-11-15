package com.glodon.tcpcopy.common;

import org.apache.commons.lang.enums.EnumUtils;
import org.apache.commons.lang.enums.ValuedEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by glodon on 16-6-29.
 */
@MappedJdbcTypes(JdbcType.INTEGER)
public class ValuedEnumTypeHandler<E extends ValuedEnum> extends BaseTypeHandler<E> {
    private Class<E> type;

    public ValuedEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        ValuedEnum valuedEnum = (ValuedEnum) parameter;
        ps.setInt(i, valuedEnum.getValue());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int i = rs.getInt(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            return getValuedEnum(i);
        }
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int i = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            return getValuedEnum(i);
        }
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int i = cs.getInt(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            return getValuedEnum(i);
        }
    }

    private E getValuedEnum(int value) {
        try {
           return (E)EnumUtils.getEnum(this.type,value);
        } catch (Exception ex) {
            throw new IllegalArgumentException(
                    "Cannot convert " + value + " to " + type.getSimpleName() + " by value.", ex);
        }
    }
}
