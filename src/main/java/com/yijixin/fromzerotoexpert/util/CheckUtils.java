package com.yijixin.fromzerotoexpert.util;

import com.yijixin.fromzerotoexpert.common.AcTrie;
import com.yijixin.fromzerotoexpert.common.ApiRestResponse;
import com.yijixin.fromzerotoexpert.common.FzteConstant;
import com.yijixin.fromzerotoexpert.exception.FzteException;
import com.yijixin.fromzerotoexpert.exception.FzteExceptionEnum;
import org.springframework.util.StringUtils;

/**
 * @Classname CheckUtils
 * @Description 检测字符串合法性的工具类
 * @Version 1.0.0
 * @Date 2022/10/15 11:06
 * @Created by 忆霁昕
 */
public class CheckUtils {
    private static AcTrie acTrie = new AcTrie();
    static {
        acTrie.build(FzteConstant.SENSITIVE_KEYS);
    }

    /***
     * todo
     * #Description 无返回值 检测用户名是否合法 不合法直接抛出异常
     * @param username
     * @return void
     * @author 忆霁昕
     * #Date 2022/10/15
     */
    public static void checkUsername(String username) throws FzteException {
        //判空
        if (StringUtils.isEmpty(username)) {
            throw new FzteException(FzteExceptionEnum.NEED_USERNAME);
        }
        //检测长度
        if (username.length() > 15) {
            throw new FzteException(FzteExceptionEnum.USERNAME_TOO_LONG);
        }
        //敏感词过滤
        if (acTrie.match(username)) {
            throw new FzteException(FzteExceptionEnum.SENSITIVE_NAME);
        }
    }

    public static void checkPassword(String password) throws FzteException {
        //判空
        if (StringUtils.isEmpty(password)) {
            throw new FzteException(FzteExceptionEnum.NEED_PASSWORD);
        }
        //检测长度 6~16
        if (password.length() < 6 || password.length() > 16) {
            throw new FzteException(FzteExceptionEnum.WRONG_PASSWORD_LENGTH);
        }
        //密码字符只能是 数字+英文大小写（算是三种字符）
        //密码必须包含 2 种及其以上字符
        int numFlag = 0;
        int lowerFlag = 0;
        int highFlag = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (checkNum(ch)) {
                numFlag = 1;
            } else if (checkLower(ch)) {
                lowerFlag = 1;
            } else if (checkUpper(ch)) {
                highFlag = 1;
            } else {
                throw new FzteException(FzteExceptionEnum.WRONG_PASSWORD);
            }
        }
        //包含两种及以上
        if (numFlag + lowerFlag + highFlag < 2) {
            throw new FzteException(FzteExceptionEnum.WRONG_PASSWORD);
        }

    }

    public static boolean checkUpper(char ch) {
        return ch <= 'Z' && ch >= 'A';
    }

    public static boolean checkLower(char ch) {
        return ch <= 'z' && ch >= 'a';
    }

    public static boolean checkNum(char ch) {
        return ch <= '9' && ch >= '0';
    }

}
