package com.project.cpx.common.util;

import org.springframework.lang.Nullable;

/**
 * @Auther: shuyiwei
 * @Date: 2020/2/29 22:58
 * @Description:
 */
public final class CheckCondition {

    public static void checkArgument(boolean expression,@Nullable Object... errorArgs){
        if(!expression){
            throw new Exception(ErrorEnum.PARAM.getCode(),String.format(ErrorEnum.PARAM.getMsg(),errorArgs));
        }
    }
    public static void checkArgument(boolean b, @Nullable String errorMessageTemplate, @Nullable Object errorArg) {
        checkArgument(b,errorArg);
    }
    public static void checkState(boolean b,@Nullable Object... errorArg){
        checkArgument(b,errorArg);
    }
    public static void checkState(boolean b, @Nullable String errorMessageTemplate, @Nullable Object errorArg){
        checkArgument(b,errorArg);
    }
}
