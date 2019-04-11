package com.netease.trading;

import com.netease.trading.util.MD5Util;
import org.junit.Test;

public class UtilTest {


    @Test
    public void testMD5() {
        String reyub = MD5Util.getMD5("reyub");
        System.out.println("reyub " + reyub);
        String s1 = MD5Util.getMD5("123");
        System.out.println("s1 " + s1);
    }

}
